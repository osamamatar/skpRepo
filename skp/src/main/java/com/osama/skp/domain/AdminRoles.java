package com.osama.skp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "admin_roles")
@Setter
@Getter
@IdClass(RoleId.class)
public class AdminRoles {

    @Id
    @Column(name = "user_name")
    private String userName;
    @Id
    @Column(name = "role_name")
    private String roleName;


}
