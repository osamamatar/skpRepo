package com.osama.skp.utilityClasses.dto;

import com.osama.skp.utilityClasses.info.OrderLineItemInfo;
import com.osama.skp.utilityClasses.info.ProductInfo;
import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class OrderLineItemDto extends OrderLineItemInfo {
    private ProductInfo product;
}
