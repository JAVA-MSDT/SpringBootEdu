package com.msdt.springmvc.entity;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Login {

    @Size(min = 6, message = "{username.not.empty}")
    private String username;

    @Pattern(regexp = "((?=.*[A-Z]).{6,10})", message = "{password.pattern}")
    private String password;
}
