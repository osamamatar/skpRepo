package com.osama.skp.service;

import com.osama.skp.dto.EmailSubscriberDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EmailSubscriberService implements BaseService<EmailSubscriberDto,Long>{
    @Override
    public EmailSubscriberDto findById(Long aLong) {
        return null;
    }

    @Override
    public Page<EmailSubscriberDto> findAll(Integer page, Integer size) {
        return null;
    }

    @Override
    public EmailSubscriberDto save(EmailSubscriberDto emailSubscriberDto) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void deleteAll(Collection<Long> ids) {

    }
}
