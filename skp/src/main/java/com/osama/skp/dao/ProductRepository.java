package com.osama.skp.dao;


import com.osama.skp.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Collection;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    void deleteAllByIdIn(Collection<Long> ids);
    @Query(value = "Select * from product where quantity >=1",nativeQuery = true)
    Page<Product> findAllProducts(Pageable pageable);
}
