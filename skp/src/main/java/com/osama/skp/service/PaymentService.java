package com.osama.skp.service;

import com.osama.skp.dao.EmailSubscriberRepository;
import com.osama.skp.dao.PaymentRepository;
import com.osama.skp.domain.Customer;
import com.osama.skp.domain.CustomerOrder;
import com.osama.skp.domain.PaymentModel;
import com.osama.skp.exceptions.AbstractGlopalException;
import com.osama.skp.util.MapperUtil;
import com.osama.skp.utilityClasses.Notifier;
import com.osama.skp.utilityClasses.dto.CustomerOrderDto;
import com.osama.skp.utilityClasses.dto.MessageRequest;
import com.osama.skp.utilityClasses.info.PaymentInfo;
import com.paypal.api.payments.*;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private APIContext apiContext;
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private Notifier notifier;
    @Autowired
    private EmailSubscriberRepository emailSubscriberRepository;
    public void  save(CustomerOrderDto order,Payment payment){
        try {
            CustomerOrder customerOrder=new CustomerOrder();
            customerOrder.setId(order.getId());

            Customer customer=new Customer();
            customer.setId(order.getCustomer().getId());

            PaymentModel paymentModel =new PaymentModel();
            paymentModel.setPaymentDate(new Date());
            paymentModel.setTransactionId(payment.getId());
            paymentModel.setAmount(order.getOrderAmount());
            paymentModel.setCustomer(customer);
            paymentModel.setPaymentStatus("PENDING");
            paymentModel.setCustomerOrder(customerOrder);
            
            paymentRepository.save(paymentModel);
        }catch (Exception e){
            e.printStackTrace();
            throw new AbstractGlopalException("Failed to save Payment Operation in data base");
        }


    }
    public Payment createPayment(Double total, String cancelUrl, String successUrl) throws PayPalRESTException {

        Amount amount = new Amount();
        amount.setCurrency("USD");
        total = new BigDecimal(total).setScale(2, RoundingMode.HALF_UP).doubleValue();
        amount.setTotal(String.format("%.2f", total));
        Transaction transaction = new Transaction();
        transaction.setDescription("skp payment");
        transaction.setAmount(amount);
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction);
        Payer payer = new Payer();
        payer.setPaymentMethod("paypal");
        Payment payment = new Payment();
        payment.setIntent("SALE");
        payment.setPayer(payer);
        payment.setTransactions(transactions);
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl(cancelUrl);
        redirectUrls.setReturnUrl(successUrl);
        payment.setRedirectUrls(redirectUrls);
        return payment.create(apiContext);
    }

    public Payment executePayment(String paymentId, String payerId) throws PayPalRESTException{
        Payment payment = new Payment();
        payment.setId(paymentId);
        PaymentExecution paymentExecute = new PaymentExecution();
        paymentExecute.setPayerId(payerId);
        return payment.execute(apiContext, paymentExecute);
    }

    @Transactional
    public void updatePaymentStatus(String paymentId, String state) {
        try {
            PaymentModel paymentModel= paymentRepository.findByTransactionId(paymentId);
            paymentModel.setPaymentStatus(state);
            paymentRepository.save(paymentModel);
           String customerMail= paymentModel.getCustomer().getEmail();
           Boolean isCustomerSubscriber= emailSubscriberRepository.existsByEmail(customerMail);
           if(isCustomerSubscriber){
               MessageRequest messageRequest=new MessageRequest(customerMail,"payment successfully","SKP Payment Confirmation");
               notifier.send(messageRequest);
           }
        }catch ( Exception  e){
            e.printStackTrace();
            throw new AbstractGlopalException("Failed to update Payment status");
        }

    }
    public Page<PaymentInfo> findAll(Integer page, Integer size) {
        try {
            return  paymentRepository.findAll(PageRequest.of(page, size)).map(payment -> (PaymentInfo) MapperUtil.mapEntityDTO(payment,PaymentInfo.class));
        }catch (Exception e){
            e.printStackTrace();
            throw new AbstractGlopalException("Failed to load all payment operations");
        }
    }
}
