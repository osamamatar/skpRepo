package com.osama.skp.dao;

import com.osama.skp.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,String> {

    @Query(value = "select * from admin where user_name=?",nativeQuery = true)
    Admin findByUserName(String userName);
    @Query(value = "delete from admin where user_name=?",nativeQuery = true)
    void deleteByUserName(String userName);
    void deleteById(String s);
}
