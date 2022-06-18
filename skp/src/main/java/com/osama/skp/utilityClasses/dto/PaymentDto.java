package com.osama.skp.utilityClasses.dto;


import com.osama.skp.utilityClasses.info.CustomerInfo;
import com.osama.skp.utilityClasses.info.CustomerOrderInfo;
import com.osama.skp.utilityClasses.info.PaymentInfo;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;
@Setter@Getter
public class PaymentDto extends PaymentInfo {
    @NotNull(message = "customer must be not empty")
    private CustomerInfo customer;
    @NotNull(message = "customerOrder must be not empty")
    private CustomerOrderInfo customerOrder;
}
