package com.github.mykhalechko.productlist.controller;

import com.github.mykhalechko.productlist.entity.User;
import com.github.mykhalechko.productlist.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @RequestMapping(value = "/registration", name = "getRegister", method = RequestMethod.GET)
    public ModelAndView getRegister() {
        return new ModelAndView("registration", "user", new User());
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ModelAndView registrationHandler(@Valid @ModelAttribute("user") User user, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        if (result.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            if (registrationService.createUser(user)) {
                modelAndView.setViewName("index");
            } else {
                modelAndView.setViewName("registration");
                modelAndView.addObject("alreadyexist", "User alreadyexist");
            }
        }
        return modelAndView;
    }
}
