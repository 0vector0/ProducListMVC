//package com.github.mykhalechko.productlist.controller;
//
//import com.github.mykhalechko.productlist.model.Product;
//import com.github.mykhalechko.productlist.service.ProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//@Controller
//public class ProductController {
//
//    @Autowired
//    private ProductService productService;
//
//    @RequestMapping(value = "products", method = RequestMethod.GET)
//    public String listProducts(Model model) {
//        model.addAttribute("product", new Product());
//        model.addAttribute("listProducts", this.productService.listProducts());
//
//        return "products";
//    }
//
//    @RequestMapping(value = "/products/add", method = RequestMethod.POST)
//    public String addProduct(@ModelAttribute("product") Product product) {
//        if (product.getId() == 0) {
//            this.productService.addProduct(product);
//        } else {
//            this.productService.updateProduct(product);
//        }
//
//        return "redirect:/products";
//    }
//
//    @RequestMapping("/remove/{id}")
//    public String removeProduct(@PathVariable("id") long id) {
//        this.productService.removeProduct(id);
//
//        return "redirect:/products";
//    }
//
//    @RequestMapping("edit/{id}")
//    public String editProduct(@PathVariable("id") long id, Model model) {
//        model.addAttribute("product", this.productService.getProductById(id));
//        model.addAttribute("listProducts", this.productService.listProducts());
//
//        return "products";
//    }
//
//    @RequestMapping("productdata/{id}")
//    public String productData(@PathVariable("id") long id, Model model) {
//        model.addAttribute("product", this.productService.getProductById(id));
//
//        return "productdata";
//    }
//}
