package com.osama.skp.domain;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor@NoArgsConstructor@Setter@Getter @EqualsAndHashCode
public class RoleId implements Serializable {

    private String userName;
    private String roleName;
}
