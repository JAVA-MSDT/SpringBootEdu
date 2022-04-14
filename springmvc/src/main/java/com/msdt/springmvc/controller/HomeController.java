package com.msdt.springmvc.controller;

import java.util.Arrays;
import java.util.List;

import com.msdt.springmvc.entity.Login;
import com.msdt.springmvc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

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

    @GetMapping("/registerPage")
    public String goToRegister() {
        System.out.println("Register Page");
        return "register";
    }

}
