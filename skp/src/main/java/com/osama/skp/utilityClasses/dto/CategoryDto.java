package com.osama.skp.utilityClasses.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryDto {
    private Long id;
    @NotBlank(message = " Category name must  be not empty")
    private String name;
    private Date lastUpdate;
    private List<ProductDto> products;
}
