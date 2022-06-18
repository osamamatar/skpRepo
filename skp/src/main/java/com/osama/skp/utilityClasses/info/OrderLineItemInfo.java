package com.osama.skp.utilityClasses.info;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderLineItemInfo {
    private Long id;
    @NotNull(message = "quantity must be not null")
    @Size(min = 1,message = "quantity must be greater than 1 item ")
    private Integer quantity;
    private ProductInfo product;

}
