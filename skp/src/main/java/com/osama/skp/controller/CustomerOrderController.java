package com.osama.skp.controller;

import com.osama.skp.enums.OrderStatus;
import com.osama.skp.service.OrderService;
import com.osama.skp.utilityClasses.dto.CustomerOrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("customer/order")
public class CustomerOrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<CustomerOrderDto> createOrder(@RequestBody @Valid CustomerOrderDto customerOrderDto){
        return ResponseEntity.ok().body(orderService.save(customerOrderDto));
    }
    @PutMapping("/{id}")
    public void updateOrderStatus(@PathVariable Long id, @RequestParam OrderStatus orderStatus){
        orderService.updateStatus(id,orderStatus);
    }
}
