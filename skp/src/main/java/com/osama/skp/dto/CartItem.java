package com.osama.skp.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CartItem {

    private Long id;
    private Integer quantity;
    private ProductDto product;
    private Double total;
}
