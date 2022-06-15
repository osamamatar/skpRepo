package com.osama.skp.service;

import com.osama.skp.dao.CategoryRepository;
import com.osama.skp.domain.Category;
import com.osama.skp.domain.Product;
import com.osama.skp.dto.CategoryDto;
import com.osama.skp.dto.ProductDto;
import com.osama.skp.exceptions.AbstractEntityNotFound;
import com.osama.skp.exceptions.AbstractGlopalException;
import com.osama.skp.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
public class CategoryService implements BaseService<CategoryDto,Long>{

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public CategoryDto findById(Long id) {
        Category category=  categoryRepository.findById(id).orElseThrow(()
                -> new AbstractEntityNotFound("category  with id: "+ id+ " not found"));
        return (CategoryDto) MapperUtil.mapEntityDTO(category, CategoryDto.class);
    }

    @Override
    public Page<Category> findAll(Integer page, Integer size) {
        try {
            return  categoryRepository.findAll(PageRequest.of(page, size));
        }catch (Exception e){
            e.printStackTrace();
            throw new AbstractGlopalException("Failed to load all Categories");
        }
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        try {
            Category  category=(Category) MapperUtil.mapEntityDTO(categoryDto,Category.class);
            categoryRepository.save(category);
            return categoryDto;
        }catch (Exception e){
            e.printStackTrace();
            throw new AbstractGlopalException("Failed to save Category");
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            categoryRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
            throw new AbstractEntityNotFound("Failed to delete Product with Id :"+id);
        }
    }

    @Override
    public void deleteAll(Collection<Long> ids) {
        try {
            categoryRepository.deleteAllByIdIn(ids);
        }catch (Exception e){
            e.printStackTrace();
            throw new AbstractEntityNotFound("Failed to delete all Product");
        }
    }
}
