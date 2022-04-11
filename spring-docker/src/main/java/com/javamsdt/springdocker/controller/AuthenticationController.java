package com.javamsdt.springdocker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {

    @GetMapping(value = "/login")
    public String getLogin() {
        return "login";
    }
}
