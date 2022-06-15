package com.osama.skp.domain;

import com.osama.skp.enums.PaymentStatus;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Table(name = "payment")
@Entity
@Setter
@Getter
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "amount must be not empty")
    @Column(name = "amount")
    private Double amount;

    @Column(name = "payment_date")
    private Date paymentDate;

    @Column(name = "payment_status")
    private PaymentStatus paymentStatus;

    @NotNull(message = "transactionId must be not empty")
    @Column(name = "transaction_id")
    private String transactionId;

    @NotNull(message = "customerOrder must be not empty")
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_order_id")
    private CustomerOrder customerOrder;

    @NotNull(message = "customer must be not empty")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="customer_id")
    private Customer customer;
}
