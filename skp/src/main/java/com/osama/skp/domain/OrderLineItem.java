package com.osama.skp.domain;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Table(name = "order_line_item")
@Entity @Setter @Getter
public class OrderLineItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "quantity must be not null")
    @Size(min = 1,message = "quantity must be greater than 1 item ")
    @Column(name = "quantity")
    private Integer quantity;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
