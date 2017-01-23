package com.github.mykhalechko.productlist.controller;

import com.github.mykhalechko.productlist.dto.UserImageDTO;
import com.github.mykhalechko.productlist.model.User;
import com.github.mykhalechko.productlist.service.UserService;
import com.github.mykhalechko.productlist.validator.UserImageValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Controller
public class FileController {

    public static final String uploadingdir = System.getProperty("user.dir") + "/images/";

    @Autowired
    private UserService userService;

    @Autowired
    private UserImageValidator userImageValidator;

    @RequestMapping(value = "/file", method = RequestMethod.GET)
    public String getFile(Model model) {
        model.addAttribute("user", userService.getAuthenticationUser());
        return "file";
    }


    @RequestMapping(value = "images/{imageName}")
    @ResponseBody
    public byte[] getImage(@PathVariable(value = "imageName") String imageName) throws IOException {

        File serverFile = new File(uploadingdir + imageName + ".jpg");

        return Files.readAllBytes(serverFile.toPath());
    }

    @RequestMapping(value = "/uploadSuccess", method = RequestMethod.GET)
    public String getUploadSuccess(Model model) {
        model.addAttribute("user", userService.getAuthenticationUser());
        return "uploadSuccess";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String uploadingPost(
            @RequestParam("file") MultipartFile uploadingFile,
            @ModelAttribute("user") User user, BindingResult bindingResult, Model model) throws IOException {

        UserImageDTO userImageDTO = new UserImageDTO();
        userImageDTO.setFile(uploadingFile);
        userImageValidator.validate(userImageDTO, bindingResult);

        if (bindingResult.hasErrors()) {
            return "file";
        }

//        File file = new File(uploadingdir + userService.getAuthenticationUser().getId() + "." + uploadingFile.getOriginalFilename().split("\\.")[1]);
        File file = new File(uploadingdir + userService.getAuthenticationUser().getId() + ".jpg");
        uploadingFile.transferTo(file);


        return "redirect:/uploadSuccess";
    }

}
