package com.msdt.springmvc.controller;

import javax.validation.Valid;

import com.msdt.springmvc.entity.User;
import com.msdt.springmvc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
    public ModelAndView registerUser(@Valid @ModelAttribute("newuser") User user, BindingResult bindingResult, ModelAndView modelAndView) {

        if(bindingResult.hasErrors()) {
            modelAndView.setViewName("register");
            return modelAndView;
        }

        User userRegistered = userService.saveUser(user);
        modelAndView.setViewName("login");
        modelAndView.addObject("dataSaved", "User Registered Successfully");
        modelAndView.addObject("username", userRegistered.getUsername());
        return modelAndView;
    }
}
