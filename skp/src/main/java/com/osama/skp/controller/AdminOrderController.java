package com.osama.skp.controller;

import com.osama.skp.domain.PaymentModel;
import com.osama.skp.enums.OrderStatus;
import com.osama.skp.service.OrderService;
import com.osama.skp.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin/adminOrder")
public class AdminOrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private  PaymentService paymentService;

    @GetMapping
    ResponseEntity<Page<?>> findAll(@RequestParam(required = false, defaultValue = "0") Integer page,
                                    @RequestParam(required = false, defaultValue = "20") Integer size){
        return ResponseEntity.ok().body(orderService.findAll(page,size));
    }

    @PutMapping("{id}")
    ResponseEntity<?> updateStatus(@PathVariable("id") Long id, @RequestParam OrderStatus orderStatus ){
        orderService.updateStatus(id,orderStatus);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/getAllPayments")
    public ResponseEntity<Page<?>> getAllPayments(@RequestParam(required = false, defaultValue = "0") Integer page,
                                                             @RequestParam(required = false, defaultValue = "20") Integer size){
        return ResponseEntity.ok().body(paymentService.findAll(page,size));
    }
}
