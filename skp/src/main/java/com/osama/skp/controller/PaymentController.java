package com.osama.skp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.osama.skp.dao.CustomerRepository;
import com.osama.skp.dao.OrderRepository;
import com.osama.skp.domain.Customer;
import com.osama.skp.domain.CustomerOrder;
import com.osama.skp.domain.PaymentModel;
import com.osama.skp.enums.OrderStatus;
import com.osama.skp.exceptions.AbstractGlopalException;
import com.osama.skp.service.OrderService;
import com.osama.skp.service.PaymentService;
import com.osama.skp.utilityClasses.dto.CustomerOrderDto;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("payment")
public class PaymentController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private PaymentService paymentService;


    public static final String SUCCESS_URL = "payment/pay/success";
    public static final String CANCEL_URL = "payment/pay/cancel";
    public static final String BASE_URL = "http://localhost:8091/skp/";


    @GetMapping ("/checkout/{orderId}")
    public String payment(@PathVariable Long orderId) {
        try {
            CustomerOrderDto order=orderService.findById(orderId);
            Payment payment = paymentService.createPayment(order.getOrderAmount(), BASE_URL + CANCEL_URL, BASE_URL + SUCCESS_URL);
            paymentService.save(order,payment);
            for(Links link:payment.getLinks()) {
                if(link.getRel().equals("approval_url")) {
                    return link.getHref();
                }
            }
        } catch (PayPalRESTException e) {
            e.printStackTrace();
            throw new AbstractGlopalException(e.getMessage());
        }
        throw new AbstractGlopalException("payment operation failed");

    }

    @GetMapping(value = CANCEL_URL)
    private void cancelPay() {
        throw new AbstractGlopalException("payment operation failed");
    }

    @GetMapping(value = SUCCESS_URL)
    private String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
        try {
            Payment payment = paymentService.executePayment(paymentId, payerId);
            System.out.println(payment.toJSON());
            paymentService.updatePaymentStatus(paymentId,payment.getState());
            if (payment.getState().equals("approved")) {
                return "success";
            }
        } catch (PayPalRESTException e) {
           e.printStackTrace();
            throw new AbstractGlopalException("payment operation failed");
        }
        throw new AbstractGlopalException("payment operation failed");
    }


}
