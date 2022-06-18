package com.osama.skp.service;

import com.osama.skp.dao.EmailSubscriberRepository;
import com.osama.skp.dao.OrderRepository;
import com.osama.skp.domain.CustomerOrder;
import com.osama.skp.domain.EmailSubscriber;
import com.osama.skp.enums.OrderStatus;
import com.osama.skp.exceptions.AbstractEntityNotFound;
import com.osama.skp.exceptions.AbstractGlopalException;
import com.osama.skp.util.MapperUtil;
import com.osama.skp.utilityClasses.dto.CustomerOrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Date;


@Service
public class OrderService implements BaseService<CustomerOrderDto,Long>{

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private EmailSubscriberRepository emailSubscriberRepository;

    @Override
    public CustomerOrderDto findById(Long id) {
            CustomerOrder customerOrder=   orderRepository.findById(id).orElseThrow(()
                    -> new AbstractEntityNotFound("order  with id: "+ id+ " not found"));
            return (CustomerOrderDto)MapperUtil.mapEntityDTO(customerOrder,CustomerOrderDto.class) ;
    }

    @Override
    public Page<CustomerOrder> findAll(Integer page, Integer size) {
        try {
          return  orderRepository.findAll(PageRequest.of(page, size));
        }catch (Exception e){
            e.printStackTrace();
            throw new AbstractGlopalException("Failed to load all Products");
        }
    }
    @Override
    public CustomerOrderDto save(CustomerOrderDto customerOrderDto) {
        try {
            customerOrderDto.setOrderStatus(OrderStatus.INPROGREES);
            customerOrderDto.setOrderDate( new Date());
            CustomerOrder customerOrder=(CustomerOrder) MapperUtil.mapEntityDTO(customerOrderDto,CustomerOrder.class);
           CustomerOrder customerOrder1= orderRepository.save(customerOrder);
            if(customerOrderDto.isSubscribeByMail()){
               if(!emailSubscriberRepository.existsByEmail(customerOrderDto.getCustomer().getEmail())){
                   EmailSubscriber  emailSubscriber=new EmailSubscriber();
                   emailSubscriber.setEmail(customerOrderDto.getCustomer().getEmail());
                   emailSubscriber.setFirstName(customerOrderDto.getCustomer().getFirstName());
                   emailSubscriber.setLastName(customerOrderDto.getCustomer().getLastName());
                   emailSubscriberRepository.save(emailSubscriber);
               }

            }
           return (CustomerOrderDto)MapperUtil.mapEntityDTO(customerOrder1,CustomerOrderDto.class);
        }catch (Exception e){
            e.printStackTrace();
            throw new AbstractGlopalException("failed to save order");
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            orderRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
            throw new AbstractEntityNotFound("Failed to delete order with Id :"+id);
        }
    }

    @Override
    @Transactional
    public void deleteAll(Collection<Long> ids) {
        try {
            orderRepository.deleteAllByIdIn(ids);
        }catch (Exception e){
            e.printStackTrace();
            throw new AbstractEntityNotFound("Failed to delete all orders");
        }
    }

    @Transactional
    public void updateStatus(Long id, OrderStatus orderStatus) {
        try {
            CustomerOrderDto customerOrderDto= this.findById(id);
            if(customerOrderDto.getOrderStatus().equals(OrderStatus.INPROGREES)&&orderStatus.equals(OrderStatus.CANCELED)){
                customerOrderDto.setOrderStatus(orderStatus);
                this.save(customerOrderDto);
            }
                throw new AbstractGlopalException("unable to cancel order");

        }catch (Exception e){
            e.printStackTrace();
            throw new AbstractGlopalException("Failed to update order status");
        }

    }


}
