package com.osama.skp.controller;

import com.osama.skp.service.CustomerService;
import com.osama.skp.utilityClasses.dto.CustomerDto;
import com.osama.skp.utilityClasses.info.CustomerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
@RestController
@RequestMapping("admin/customers")
public class CustomerController implements BaseController<CustomerInfo,Long>{
    @Autowired
    private CustomerService customerService;
    @Override
    public ResponseEntity<Page<?>> findAll(Integer page, Integer size) {
        return ResponseEntity.ok(customerService.findAll(page, size));    }

    @Override
    public ResponseEntity<CustomerInfo> findById(Long id) {
        return ResponseEntity.ok(customerService.findById(id));
    }

    @Override
    public ResponseEntity<CustomerInfo> save(CustomerInfo customerDto) {
        return ResponseEntity.ok(customerService.save((CustomerDto) customerDto));
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        customerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<?> deleteAll(Collection<Long> ids) {
        customerService.deleteAll(ids);
        return ResponseEntity.noContent().build();
    }
}
