package com.msdt.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String goHome() {
        System.out.println("Home Page");
        return "index";
    }

    @GetMapping("/")
    public String homePage() {
        System.out.println("Home Page");
        return "index";
    }

    @GetMapping("/searchPage")
    public String goToSearch() {
        System.out.println("Search Page");
        return "search";
    }

    @GetMapping("/loginPage")
    public String goToLogin() {
        System.out.println("Login Page");
        return "login";
    }
}
