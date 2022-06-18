package com.osama.skp.utilityClasses.dto;


import com.osama.skp.domain.AdminRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter@Getter
@AllArgsConstructor@NoArgsConstructor
public class AdminDto {
    private String userName;
    private String password;
    private List<AdminRole> role;
}
