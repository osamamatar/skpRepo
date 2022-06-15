package com.osama.skp.service;

import com.osama.skp.dto.CustomerOrderDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CustomerOrderService implements BaseService<CustomerOrderDto,Long>{
    @Override
    public CustomerOrderDto findById(Long aLong) {
        return null;
    }

    @Override
    public Page<CustomerOrderDto> findAll(Integer page, Integer size) {
        return null;
    }

    @Override
    public CustomerOrderDto save(CustomerOrderDto customerOrderDto) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void deleteAll(Collection<Long> ids) {

    }
}
