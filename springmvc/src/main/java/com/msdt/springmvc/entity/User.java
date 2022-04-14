package com.msdt.springmvc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;
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

    @Size(min = 6, message = "User name should be minimum 6 characters long")
    private String username;

    @Pattern(regexp = "((?=.*[A-Z]).{6,10})", message = " Password must have one upercase and should be between 6 - 10 characters" )
    private String password;
    private String firstName;
    private String lastName;
    private String dateOfBirth;

    @NotNull(message = "Activity Cannot be empty")
    private String activity;
    private String gender;

}
