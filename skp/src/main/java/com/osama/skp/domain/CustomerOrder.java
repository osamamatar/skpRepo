package com.osama.skp.domain;

import com.osama.skp.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table(name = "customer_order")
@Entity
@Setter
@Getter
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "orderDate must be not empty")
    @Column(name = "order_date")
    private Date orderDate;

    @NotNull(message = "orderStatus must be not empty")
    @Column(name = "order_status")
    private OrderStatus orderStatus;

    @NotNull(message = "orderAmount must be not empty")
    @Column(name = "order_amount")
    private Double orderAmount;

    @NotNull(message = "customer must be not empty")
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_order_id", referencedColumnName = "id")
    private List<OrderLineItem> orderLineItemList=new ArrayList<>();


}
