package com.osama.skp.controller;

import com.osama.skp.dto.ProductDto;
import com.osama.skp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("admin/product")
public class ProductController implements  BaseController<ProductDto,Long>{
    @Autowired
    private ProductService productService;
    @Override
    public ResponseEntity<Page<?>> findAll(Integer page, Integer size) {
        return ResponseEntity.ok(productService.findAll(page, size));
    }

    @Override
    public ResponseEntity<ProductDto> findById(Long id) {
        return ResponseEntity.ok(productService.findById(id));
    }
    @Override
    public ResponseEntity<ProductDto> save(ProductDto productDto) {
        return ResponseEntity.ok(productService.save(productDto));
    }
    @Override
    public ResponseEntity<?> delete(Long id) {
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @Override
    public ResponseEntity<?> deleteAll(Collection<Long> ids) {
        productService.deleteAll(ids);
        return ResponseEntity.noContent().build();
    }


}
