package com.osama.skp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Table(name = "customer")
@Entity @Setter @Getter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email(message = "Email should be valid")
    @Column(name="email")
    @NotBlank(message = "email must  be not empty")
    private String email;

    @NotBlank(message = "firstName must be not empty")
    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @NotNull(message = "phone must be not empty")
    @Column(name="phone")
    private String phone;

    @NotNull(message = "postalCode must be not empty")
    @Column(name="postal_code")
    private String postalCode;

    @NotNull(message = "street must be not empty")
    @Column(name="street")
    private String street;
}
