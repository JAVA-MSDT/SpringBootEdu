package com.msdt.springmvc.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler({AppException.class, AsyncRequestTimeoutException.class})
    public String handleException() {
        return "error";
    }
}
