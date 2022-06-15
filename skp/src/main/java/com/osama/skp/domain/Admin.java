package com.osama.skp.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "admin")
@Entity
@Setter @Getter
public class Admin {

    @Id
    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;
}
