package com.github.mykhalechko.productlist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContentController {

    @RequestMapping(value = "/content")
    public ModelAndView getIndex() {
        return new ModelAndView("content");
    }

}
