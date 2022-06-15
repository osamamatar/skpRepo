package com.osama.skp.dto;

import com.osama.skp.domain.Customer;
import com.osama.skp.domain.OrderLineItem;
import com.osama.skp.enums.OrderStatus;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerOrderDto {

    private Long id;
    @NotNull(message = "orderDate must be not empty")
    private Date orderDate;
    @NotNull(message = "orderStatus must be not empty")
    private OrderStatus orderStatus;
    @NotNull(message = "orderAmount must be not empty")
    private Double orderAmount;
    @NotNull(message = "customer must be not empty")
    private Customer customer;
    private List<OrderLineItem> orderLineItemList=new ArrayList<>();
}
