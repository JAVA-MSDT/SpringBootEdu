package com.msdt.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {

    @GetMapping("/redirectToLinkedin")
    public String redirectToLinkedin() {
        return "redirect:https://www.linkedin.com/feed/";
    }
}
