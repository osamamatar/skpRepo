package com.osama.skp.dao;

import com.osama.skp.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    void deleteAllByIdIn(Collection<Long> ids);
}
