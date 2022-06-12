package com.osama.skp.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

public interface BaseController <T, ID>{

    @GetMapping
    ResponseEntity<Page<T>> findAll(@RequestParam(required = false, defaultValue = "0") Integer page,
                                    @RequestParam(required = false, defaultValue = "20") Integer size);

    @GetMapping("/{id}")
    ResponseEntity<T> findById(@PathVariable("id") ID id);

    @PostMapping
    ResponseEntity<T> save(@RequestBody @Valid T t);


    @DeleteMapping("{id}")
    ResponseEntity<?> delete(@PathVariable("id") ID id);


    @DeleteMapping
    ResponseEntity<?> deleteAll(@RequestParam("ids") Collection<String> ids);

}
