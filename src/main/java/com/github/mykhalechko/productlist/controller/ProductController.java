package com.github.mykhalechko.productlist.controller;

import com.github.mykhalechko.productlist.model.Product;
import com.github.mykhalechko.productlist.service.ProductService;
import com.github.mykhalechko.productlist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String listProducts(Model model) {
        List<Product> products = this.productService.findAllUserProducts(userService.getAuthenticationUser().getId());
        System.out.println(products);
        model.addAttribute("listProducts", products);
        return "products";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("product", new Product());
        return "add";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") Product product) {

        product.setUser(userService.getAuthenticationUser());
        this.productService.create(product);
        return "redirect:/products";
    }

    @RequestMapping("/delete/{id}")
    public String removeProduct(@PathVariable("id") long id) {
        this.productService.deleteById(id);

        return "redirect:/products";
    }

    @RequestMapping(value = "/edit/{id}")
    public String editProduct(@PathVariable("id") long id, Model model) {
        model.addAttribute("product", this.productService.findById(id));
        return "editproduct";
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String editProduct(@ModelAttribute("product") Product product) {

        System.err.println(product.getId());

        this.productService.edit(product);
        return "redirect:/products";
    }

    @RequestMapping("/data/{id}")
    public String productData(@PathVariable("id") long id, Model model) {
        model.addAttribute("product", this.productService.findById(id));

        return "product";
    }


}
