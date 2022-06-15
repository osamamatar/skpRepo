package com.osama.skp.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Cart {

    private List<CartItem> cartItems;
    private Double cartTotal;

}
