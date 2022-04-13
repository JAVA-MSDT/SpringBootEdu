package com.msdt.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import com.msdt.springmvc.entity.Product;
import com.msdt.springmvc.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchController {

    private final ProductService productService;

    public SearchController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam("search") String search, ModelAndView modelAndView) {
        modelAndView.setViewName("search:: " + search);
        modelAndView.setViewName("search");

        List<Product> products = productService.searchByName(search);
        modelAndView.addObject("products", products);
        return modelAndView;
    }
}
