package com.osama.skp.utilityClasses.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.osama.skp.utilityClasses.info.ProductInfo;
import lombok.Getter;
import lombok.Setter;

@Setter@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDto extends ProductInfo {

    private Long categoryId;

}
