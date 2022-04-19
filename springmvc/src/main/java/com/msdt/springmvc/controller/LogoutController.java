package com.msdt.springmvc.controller;

import javax.servlet.http.HttpSession;

import com.msdt.springmvc.entity.Login;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class LogoutController {

    @GetMapping("logout")
    public String logOut(HttpSession session) {
        session.invalidate();
        return "redirect:/home";
    }
}
