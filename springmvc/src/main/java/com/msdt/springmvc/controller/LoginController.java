package com.msdt.springmvc.controller;

import com.msdt.springmvc.entity.Login;
import com.msdt.springmvc.entity.User;
import com.msdt.springmvc.exceptions.AppException;
import com.msdt.springmvc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("login")
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public String Login(@ModelAttribute("login") Login login) {
        User user = userService.getUserByLoginCred(login.getUsername(), login.getPassword());
        if(user == null) {
            throw new AppException("User not Found");
        }
        System.out.println(user);
        return "forward:/userprofile";
    }
}
