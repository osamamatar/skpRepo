package com.osama.skp.service.order;

import org.springframework.data.domain.Page;

import java.util.Collection;

public interface BaseService<T, ID>  {

    T findById(ID id);
    Page<T> findAll(Integer page, Integer size);
    T save(T t, String token);
    void deleteById(ID id, String token);
    void deleteAll(Collection<String> ids, String token);
}
