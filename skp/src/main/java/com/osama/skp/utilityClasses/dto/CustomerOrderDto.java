package com.osama.skp.utilityClasses.dto;

import com.osama.skp.domain.Customer;
import com.osama.skp.domain.OrderLineItem;
import com.osama.skp.utilityClasses.info.CustomerInfo;
import com.osama.skp.utilityClasses.info.CustomerOrderInfo;
import com.osama.skp.utilityClasses.info.OrderLineItemInfo;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Setter@Getter
public class CustomerOrderDto extends CustomerOrderInfo {
    private List<OrderLineItemInfo> orderLineItemList=new ArrayList<>();
    @NotNull(message = "customer must be not empty")
    private CustomerInfo customer;
    private boolean subscribeByMail;
}
