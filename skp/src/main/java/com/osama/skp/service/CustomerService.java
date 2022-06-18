package com.osama.skp.service;

import com.osama.skp.dao.CustomerRepository;
import com.osama.skp.dao.EmailSubscriberRepository;
import com.osama.skp.domain.Customer;
import com.osama.skp.domain.EmailSubscriber;
import com.osama.skp.domain.Product;
import com.osama.skp.exceptions.AbstractEntityNotFound;
import com.osama.skp.exceptions.AbstractGlopalException;
import com.osama.skp.util.MapperUtil;
import com.osama.skp.utilityClasses.dto.CustomerDto;
import com.osama.skp.utilityClasses.dto.EmailSubscriberDto;
import com.osama.skp.utilityClasses.dto.ProductDto;
import com.osama.skp.utilityClasses.info.CustomerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class CustomerService implements BaseService<CustomerDto,Long>{
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public CustomerDto findById(Long id) {
        Customer customer =  customerRepository.findById(id).orElseThrow(()
                -> new AbstractEntityNotFound("customer  with id: "+ id+ " not found"));
        return (CustomerDto) MapperUtil.mapEntityDTO(customer
                , CustomerDto.class);
    }
    @Override
    public Page<CustomerInfo> findAll(Integer page, Integer size) {
        try {
            return  customerRepository.findAll(PageRequest.of(page, size)).map(customer -> (CustomerInfo) MapperUtil.mapEntityDTO(customer,CustomerInfo.class));
        }catch (Exception e){
            e.printStackTrace();
            throw new AbstractGlopalException("Failed to load all customers");
        }
    }

    @Override
    public CustomerDto save(CustomerDto customerDto) {
        try {
            Customer customer=(Customer)MapperUtil.mapEntityDTO(customerDto
                    , EmailSubscriber.class);
            customerRepository.save(customer);
            return customerDto;
        }catch (Exception e){
            e.printStackTrace();
            throw new AbstractGlopalException("Failed to save  customer");
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            customerRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
            throw new AbstractEntityNotFound("Failed to delete customer with Id :"+id);
        }
    }

    @Override
    @Transactional
    public void deleteAll(Collection<Long> ids) {
        try {
            customerRepository.deleteAllByIdIn(ids);
        }catch (Exception e){
            e.printStackTrace();
            throw new AbstractEntityNotFound("Failed to delete all customers");
        }
    }
}
