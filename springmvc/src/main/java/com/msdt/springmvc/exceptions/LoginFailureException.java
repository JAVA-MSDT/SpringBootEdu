package com.msdt.springmvc.exceptions;

import com.msdt.springmvc.restcontrollers.LoginRestController;

public class LoginFailureException extends Exception{

    public LoginFailureException(String message) {
        super(message);
    }
}
