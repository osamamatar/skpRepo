package com.osama.skp.utilityClasses.info;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.sql.Blob;
import java.util.Date;
@Setter@Getter
public class ProductInfo {
    private Long id;
    @NotBlank(message="description must be not null")
    private String description;
    private String code;
    private Blob image;
    private Date lastUpdate;
    private Double price;
    private Integer quantity;

}
