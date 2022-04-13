package com.msdt.springmvc.controller;

import com.msdt.springmvc.entity.User;
import com.msdt.springmvc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registeruser")
    public ModelAndView registerUser(@ModelAttribute("newuser") User user, ModelAndView modelAndView) {
        System.out.println("User:: " + user);
        User userRegistered = userService.saveUser(user);
        System.out.println("userRegistered:: " + userRegistered);
        modelAndView.setViewName("login");
        modelAndView.addObject("dataSaved", "User Registered Successfully");
        modelAndView.addObject("username", userRegistered.getUsername());
        return modelAndView;
    }
}
