package com.github.mykhalechko.productlist.controller;

import com.github.mykhalechko.productlist.dto.UserAvatarDTO;
import com.github.mykhalechko.productlist.entity.User;
import com.github.mykhalechko.productlist.entity.UserAvatar;
import com.github.mykhalechko.productlist.service.UserAvatarService;
import com.github.mykhalechko.productlist.service.UserService;
import com.github.mykhalechko.productlist.validator.ImageValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@Controller
public class FileController {

    @Autowired
    private UserService userService;

    @Autowired
    private ImageValidator imageValidator;

    @Autowired
    private UserAvatarService userAvatarService;

    @RequestMapping(value = "images/avatars/{imageName}")
    @ResponseBody
    public byte[] getImage(@PathVariable(value = "imageName") String imageName) throws IOException {

        Long userId = userService.getAuthenticationUser().getId();
        User user = userService.findById(userId);

        UserAvatar userAvatar = user.getUserAvatar();
        if (userAvatar != null) {
            return userAvatar.getImage();
        } else {
            ClassPathResource cpr = new ClassPathResource("public/images/default-avatar.png");
            return FileCopyUtils.copyToByteArray(cpr.getInputStream());
        }
    }

    @Transactional
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String uploadingPost(
            @Valid @ModelAttribute("userAvatar") UserAvatarDTO userAvatarDTO,
            BindingResult bindingResult, Model model) throws IOException {

        imageValidator.validate(userAvatarDTO.getFile(), bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", userService.getAuthenticationUser());
            return "user";
        }

        byte[] byteArr = userAvatarDTO.getFile().getBytes();
        UserAvatar userAvatar = new UserAvatar();
        User user = userService.getAuthenticationUser();

        userAvatar.setImage(byteArr);
        userAvatar.setUser(user);
        if (user.getUserAvatar() != null) {
            userAvatarService.deleteById(user.getUserAvatar().getId());
        }
        user.setUserAvatar(userAvatar);
        userService.edit(user);

        return "redirect:/user";
    }

}
