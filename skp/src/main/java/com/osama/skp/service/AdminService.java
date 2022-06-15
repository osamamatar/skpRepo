package com.osama.skp.service;

import com.osama.skp.dao.AdminRepository;
import com.osama.skp.dto.AdminDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public class AdminService implements BaseService<AdminDto,Long>{

    @Autowired
    private AdminRepository adminRepository;
    @Override
    public AdminDto findById(Long id) {
        return null;
    }

    @Override
    public Page<AdminDto> findAll(Integer page, Integer size) {
        return null;
    }

    @Override
    public AdminDto save(AdminDto adminDto) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void deleteAll(Collection<Long> ids) {

    }
}
