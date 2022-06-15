package com.osama.skp.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Blob;
import java.util.Date;

@Table(name = "product")
@Entity @Setter @Getter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="description must be not null")
    @Column(name = "description")
    private String description;

    @Column(name = "code")
    private String code;

    @Column(name = "image")
    private Blob image;

    @Column(name = "last_update")
    private Date lastUpdate;

    @Column(name = "price")
    private Double price;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "category_id")
    private Long categoryId;




}
