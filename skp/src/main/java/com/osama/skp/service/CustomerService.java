package com.osama.skp.service;

import com.osama.skp.dto.CustomerDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CustomerService implements BaseService<CustomerDto,Long>{
    @Override
    public CustomerDto findById(Long aLong) {
        return null;
    }

    @Override
    public Page<CustomerDto> findAll(Integer page, Integer size) {
        return null;
    }

    @Override
    public CustomerDto save(CustomerDto customerDto) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void deleteAll(Collection<Long> ids) {

    }
}
