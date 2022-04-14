package com.msdt.springmvc.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.validation.Valid;

import com.msdt.springmvc.entity.User;
import com.msdt.springmvc.service.UserService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, "dateOfBirth",
                new CustomDateEditor(new SimpleDateFormat("yyy-mm-dd"), true));
    }

    @PostMapping("/registeruser")
    public ModelAndView registerUser(@Valid @ModelAttribute("newuser") User user, BindingResult bindingResult,
            ModelAndView modelAndView) {
        System.out.println(user.getDateOfBirth());
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("register");
            modelAndView.addObject("genderItems", Arrays.asList("Male", "Female", "Other"));
            return modelAndView;
        }

        User userRegistered = userService.saveUser(user);
        modelAndView.setViewName("login");
        modelAndView.addObject("dataSaved", "User Registered Successfully");
        modelAndView.addObject("username", userRegistered.getUsername());
        return modelAndView;
    }
}
