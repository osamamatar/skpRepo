package com.osama.skp.dao;

import com.osama.skp.domain.AdminRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRoleRepository extends JpaRepository<AdminRole,String> {
    @Query(value = "select * from admin_roles where user_name=?",nativeQuery = true)
    List<AdminRole> findByUserName(String userName);

    @Query(value = "delete from admin_roles where user_name=?",nativeQuery = true)
    void deleteByUserName(String userName);

    void deleteById(String s);
}
