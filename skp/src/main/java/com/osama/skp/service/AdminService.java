package com.osama.skp.service;

import com.osama.skp.dao.AdminRepository;
import com.osama.skp.dao.AdminRoleRepository;
import com.osama.skp.domain.Admin;
import com.osama.skp.domain.AdminRole;
import com.osama.skp.exceptions.AbstractEntityNotFound;
import com.osama.skp.exceptions.AbstractGlopalException;
import com.osama.skp.utilityClasses.dto.AdminDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
public class AdminService implements BaseService<AdminDto,String>{

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private AdminRoleRepository adminRoleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public AdminDto findById(String s) {
        try {
            Admin admin= adminRepository.findByUserName(s);
            List<AdminRole> adminRole= adminRoleRepository.findByUserName(s);
            return new AdminDto(admin.getUserName(),admin.getPassword(),adminRole);
        }catch (Exception e){
            e.printStackTrace();
            throw new AbstractEntityNotFound("Failed to fetch with user name :"+s);
        }
    }
    @Override
    public Page<?> findAll(Integer page, Integer size) {
      try {
         return adminRepository.findAll(PageRequest.of(page,size));
      }catch (Exception e){
          e.printStackTrace();
          throw new AbstractGlopalException("Failed To Load all users");
      }
    }
    @Override
@Transactional
    public AdminDto save(AdminDto adminDto) {
        try {
          String password=  passwordEncoder.encode(adminDto.getPassword());
            adminRepository.save(new Admin(adminDto.getUserName(),password,true));
            for (AdminRole adminRole: adminDto.getRole()) {
                adminRoleRepository.save(new AdminRole(adminDto.getUserName(),adminRole.getRoleName()));
            }
            return adminDto;
        }catch (Exception e){
            e.printStackTrace();
            throw new AbstractGlopalException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public void deleteById(String id) {
        try {
            adminRoleRepository.deleteById(id);
            adminRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
            throw new AbstractEntityNotFound("Failed to delete admin with Id :"+id);
        }
    }

    @Override
    public void deleteAll(Collection<String> strings) {

    }
}
