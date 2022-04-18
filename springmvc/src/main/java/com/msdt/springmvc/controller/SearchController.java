package com.msdt.springmvc.controller;

import com.msdt.springmvc.entity.Product;
import com.msdt.springmvc.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.Callable;

@Controller
public class SearchController {

    private final ProductService productService;

    public SearchController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/search")
    public Callable<ModelAndView> search(@RequestParam("search") String search, ModelAndView modelAndView, HttpServletRequest request) {
        modelAndView.setViewName("search:: " + search);
        modelAndView.setViewName("search");
        System.out.println("Async Flag: " + request.isAsyncSupported());
        System.out.println("Thread Name from Servlet container: " + Thread.currentThread().getName());

        return () -> {
            Thread.sleep(3000);
            System.out.println("Thread Name from Task Execute: " + Thread.currentThread().getName());
            List<Product> products = productService.searchByName(search);
            modelAndView.addObject("products", products);
            return modelAndView;
        };
    }
}
