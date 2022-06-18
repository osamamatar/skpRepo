package com.osama.skp.utilityClasses.info;


import com.osama.skp.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;
@Setter@Getter@AllArgsConstructor@NoArgsConstructor
public class CustomerOrderInfo {
    private Long id;
    private Date orderDate;
    private OrderStatus orderStatus;
    @NotNull(message = "orderAmount must be not empty")
    private Double orderAmount;


}
