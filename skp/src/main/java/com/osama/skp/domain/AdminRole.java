package com.osama.skp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "admin_roles")
@Setter
@Getter
@IdClass(RoleId.class)
@AllArgsConstructor@NoArgsConstructor
public class AdminRole {

    @Id
    @Column(name = "user_name")
    private String userName;
    @Id
    @Column(name = "role_name")
    private String roleName;


}
