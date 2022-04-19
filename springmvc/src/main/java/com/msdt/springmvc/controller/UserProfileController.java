package com.msdt.springmvc.controller;

import com.msdt.springmvc.entity.Login;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserProfileController {

    @PostMapping("/userprofile")
    public ModelAndView userProfile(@SessionAttribute("login") Login login, ModelAndView modelAndView) {
        System.out.println("User Profile:: " + login);
        modelAndView.setViewName("profile");
        return modelAndView;
    }
}
