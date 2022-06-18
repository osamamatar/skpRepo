package com.osama.skp.utilityClasses.info;

import com.osama.skp.utilityClasses.dto.CustomerOrderDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Setter@Getter
public class PaymentInfo {
    private Long id;
    @NotNull(message = "amount must be not empty")
    private Double amount;
    private Date paymentDate;
    private String paymentStatus;
    @NotNull(message = "transactionId must be not empty")
    private String transactionId;

}
