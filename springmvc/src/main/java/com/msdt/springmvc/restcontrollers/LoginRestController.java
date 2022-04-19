package com.msdt.springmvc.restcontrollers;

import com.msdt.springmvc.entity.Login;
import com.msdt.springmvc.entity.User;
import com.msdt.springmvc.exceptions.LoginFailureException;
import com.msdt.springmvc.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginRestController {

    private final UserService userService;

    public LoginRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/login")
    public ResponseEntity login(@RequestBody Login login) throws LoginFailureException {
        User user = userService.getUserByLoginCred(login.getUsername(), login.getPassword());
        if(user == null) {
            throw new LoginFailureException("Invalid Credentials");
        }else {
            return new ResponseEntity(user, HttpStatus.OK);
        }
    }
}
