package com.msdt.springmvc.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min = 6, message = "{username.not.empty}")
    private String username;

    @Pattern(regexp = "((?=.*[A-Z]).{6,10})", message = "{password.pattern}" )
    private String password;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;

    @NotNull(message = "{activity.not.empty}")
    private String activity;
    private String gender;

}
