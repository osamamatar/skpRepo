package com.osama.skp.service;

import org.springframework.data.domain.Page;
import java.util.Collection;

public interface BaseService<T, ID> {
    T findById(ID id);
    Page<?> findAll(Integer page, Integer size);
    T save(T t);
    void deleteById(ID id);
    void deleteAll(Collection<ID> ids);
}
