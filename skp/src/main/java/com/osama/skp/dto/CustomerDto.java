package com.osama.skp.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter@Getter
public class CustomerDto {

    private Long id;
    @Email(message = "Email should be valid")
    @NotBlank(message = "email must  be not empty")
    private String email;
    @NotBlank(message = "firstName must be not empty")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @NotNull(message = "phone must be not empty")
    private String phone;
    @NotNull(message = "postalCode must be not empty")
    private String postalCode;
    @NotNull(message = "street must be not empty")
    private String street;
}
