package com.osama.skp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Table(name = "email_subscriber")
@Entity@Setter@Getter
public class EmailSubscriber {

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
}
