package com.osama.skp.dao;

import com.osama.skp.domain.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface OrderRepository extends JpaRepository<CustomerOrder,Long> {
    void deleteAllByIdIn(Collection<Long> ids);
}
