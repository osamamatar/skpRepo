package com.osama.skp.controller;

import com.osama.skp.utilityClasses.dto.CategoryDto;
import com.osama.skp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("customer/category")
public class CategoryController implements BaseController<CategoryDto,Long> {
    @Autowired
    private CategoryService categoryService;

    @Override
    public ResponseEntity<Page<?>> findAll(Integer page, Integer size) {
        return ResponseEntity.ok(categoryService.findAll(page, size));
    }

    @Override
    public ResponseEntity<CategoryDto> findById(Long id) {
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @Override
    public ResponseEntity<CategoryDto> save(CategoryDto categoryDto) {
        return ResponseEntity.ok(categoryService.save(categoryDto));
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        categoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<?> deleteAll(Collection<Long> ids) {
        categoryService.deleteAll(ids);
        return ResponseEntity.noContent().build();
    }
}
