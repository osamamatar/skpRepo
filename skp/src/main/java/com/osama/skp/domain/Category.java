package com.osama.skp.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Table(name = "category")
@Entity @Setter @Getter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = " Category name must  be not empty")
    @Column(name = "name")
     private String name;

    @Column(name = "last_update")
     private Date lastUpdate;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private List<Product> products;
}
