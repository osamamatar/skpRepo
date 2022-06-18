package com.osama.skp.service;

import com.osama.skp.dao.EmailSubscriberRepository;
import com.osama.skp.domain.EmailSubscriber;
import com.osama.skp.domain.Product;
import com.osama.skp.exceptions.AbstractEntityNotFound;
import com.osama.skp.exceptions.AbstractGlopalException;
import com.osama.skp.util.ExcelHelper;
import com.osama.skp.util.MapperUtil;
import com.osama.skp.utilityClasses.dto.EmailSubscriberDto;
import com.osama.skp.utilityClasses.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.util.Collection;
import java.util.List;

@Service
public class EmailSubscriberService implements BaseService<EmailSubscriberDto,Long>{
    @Autowired
    private EmailSubscriberRepository emailSubscriberRepository;

    @Override
    public EmailSubscriberDto findById(Long id) {
        EmailSubscriber emailSubscriber =  emailSubscriberRepository.findById(id).orElseThrow(()
                -> new AbstractEntityNotFound("EmailSubscriber  with id: "+ id+ " not found"));
        return (EmailSubscriberDto) MapperUtil.mapEntityDTO(emailSubscriber
                , EmailSubscriberDto.class);
    }

    @Override
    public Page<EmailSubscriber> findAll(Integer page, Integer size) {
        try {
            return  emailSubscriberRepository.findAll(PageRequest.of(page, size));
        }catch (Exception e){
            e.printStackTrace();
            throw new AbstractGlopalException("Failed to load all Products");
        }
    }

    @Override
    public EmailSubscriberDto save(EmailSubscriberDto emailSubscriberDto) {
        try {
            EmailSubscriber emailSubscriber=(EmailSubscriber)MapperUtil.mapEntityDTO(emailSubscriberDto
                    , EmailSubscriber.class);
            emailSubscriberRepository.save(emailSubscriber);
            return emailSubscriberDto;
        }catch (Exception e){
            e.printStackTrace();
            throw new AbstractGlopalException("Failed to save  EmailSubscriber");
        }

    }

    @Override
    public void deleteById(Long id) {
        try {
            emailSubscriberRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
            throw new AbstractEntityNotFound("Failed to delete EmailSubscriber with Id :"+id);
        }
    }

    @Override
    public void deleteAll(Collection<Long> ids) {
        try {
            emailSubscriberRepository.deleteAllByIdIn(ids);
        }catch (Exception e){
            e.printStackTrace();
            throw new AbstractEntityNotFound("Failed to delete all EmailSubscribers");
        }
    }
    public ByteArrayInputStream exportAsExcel(){
      List<EmailSubscriber> emailSubscribers= emailSubscriberRepository.findAll();
        ByteArrayInputStream data= ExcelHelper.emailSubscribersToExcel(emailSubscribers);
        return data;
    }

}
