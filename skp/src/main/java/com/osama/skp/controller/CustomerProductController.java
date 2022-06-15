package com.osama.skp.controller;

import com.osama.skp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class CustomerProductController {
    @Autowired
    private ProductService productService;
    @GetMapping
    public ResponseEntity<Page<?>> findAllNotEmptyProducts(@RequestParam(required = false, defaultValue = "0") Integer page, @RequestParam(required = false, defaultValue = "20") Integer size) {
        return ResponseEntity.ok(productService.findAllNotEmptyProducts(page, size));
    }
}
