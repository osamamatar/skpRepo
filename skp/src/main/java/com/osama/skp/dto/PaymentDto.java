package com.osama.skp.dto;

import com.osama.skp.domain.Customer;
import com.osama.skp.domain.CustomerOrder;
import com.osama.skp.enums.PaymentStatus;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Setter@Getter
public class PaymentDto {

    private Long id;
    @NotNull(message = "amount must be not empty")
    private Double amount;
    private Date paymentDate;
    private PaymentStatus paymentStatus;
    @NotNull(message = "transactionId must be not empty")
    private String transactionId;
    @NotNull(message = "customerOrder must be not empty")
    private CustomerOrderDto customerOrder;
    @NotNull(message = "customer must be not empty")
    private CustomerDto customer;
}
