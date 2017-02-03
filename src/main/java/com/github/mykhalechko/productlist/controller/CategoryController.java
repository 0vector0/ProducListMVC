package com.github.mykhalechko.productlist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class CategoryController {

    public String getCategory() {
        return "category";
    }

}
