package com.osama.skp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.osama.skp.domain.Category;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.sql.Blob;
import java.util.Date;

@Setter@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDto {

    private Long id;
    @NotBlank(message="description must be not null")
    private String description;
    private String code;
    private Blob image;
    private Date lastUpdate;
    private Double price;
    private Integer quantity;
    private Long categoryId;

}
