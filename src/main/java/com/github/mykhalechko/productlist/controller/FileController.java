package com.github.mykhalechko.productlist.controller;

import com.github.mykhalechko.productlist.model.User;
import com.github.mykhalechko.productlist.model.UserAvatar;
import com.github.mykhalechko.productlist.service.UserAvatarService;
import com.github.mykhalechko.productlist.service.UserService;
import com.github.mykhalechko.productlist.validator.UserImageValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class FileController {

    public static final String uploadingdir = System.getProperty("user.dir") + "/images/";

    @Autowired
    private UserService userService;

    @Autowired
    private UserImageValidator userImageValidator;

    @Autowired
    private UserAvatarService userAvatarService;

    @RequestMapping(value = "/file", method = RequestMethod.GET)
    public String getFile(Model model) {

        model.addAttribute("user", userService.getAuthenticationUser());
        return "file";
    }


    @RequestMapping(value = "images/avatars/{imageName}")
    @ResponseBody
    public byte[] getImage(@PathVariable(value = "imageName") String imageName) throws IOException {

//        UserAvatar userAvatar = userAvatarService.findByUserId(userService.getAuthenticationUser().getId());
        Long userId = userService.getAuthenticationUser().getId();
        User user = userService.findById(userId);

        UserAvatar userAvatar = user.getUserAvatar();
        return userAvatar.getImage();

//        File serverFile = new File(uploadingdir + imageName + ".jpg");

//        return Files.readAllBytes(serverFile.toPath());
    }

    @RequestMapping(value = "/uploadSuccess", method = RequestMethod.GET)
    public String getUploadSuccess(Model model) {
        model.addAttribute("user", userService.getAuthenticationUser());
        return "uploadSuccess";
    }

    @Transactional
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String uploadingPost(
            @RequestParam("file") MultipartFile uploadingFile,
            @ModelAttribute("user") User user, BindingResult bindingResult, Model model) throws IOException {


        byte[] byteArr = uploadingFile.getBytes();
        UserAvatar userAvatar = new UserAvatar();
        user = userService.getAuthenticationUser();

        userAvatar.setImage(byteArr);
        userAvatar.setUser(user);
        if (user.getUserAvatar() != null) {
            userAvatarService.deleteById(user.getUserAvatar().getId());
        }
        user.setUserAvatar(userAvatar);
        userService.edit(user);

        return "redirect:/uploadSuccess";
    }

}
