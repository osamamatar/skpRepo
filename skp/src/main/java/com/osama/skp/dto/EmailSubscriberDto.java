package com.osama.skp.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
@Setter@Getter
public class EmailSubscriberDto {

    private Long id;
    @Email(message = "Email should be valid")
    @NotBlank(message = "email must  be not empty")
    private String email;
    @NotBlank(message = "firstName must be not empty")
    private String firstName;
    private String lastName;
}
