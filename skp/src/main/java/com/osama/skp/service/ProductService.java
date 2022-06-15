package com.osama.skp.service;

import com.osama.skp.dao.ProductRepository;
import com.osama.skp.domain.Product;
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
public class ProductService implements BaseService<ProductDto,Long>{

    @Autowired
    private ProductRepository productRepository;
    @Override
    public ProductDto findById(Long id) {
        Product product=  productRepository.findById(id).orElseThrow(()
                -> new AbstractEntityNotFound("Product  with id: "+ id+ " not found"));
        return (ProductDto) MapperUtil.mapEntityDTO(product
                , ProductDto.class);
    }

    @Override
    public Page<Product> findAll(Integer page, Integer size) {
        try {
            return  productRepository.findAll(PageRequest.of(page, size));
        }catch (Exception e){
            e.printStackTrace();
            throw new AbstractGlopalException("Failed to load all Products");
        }
    }
    public Page<Product> findAllNotEmptyProducts(Integer page, Integer size) {
        try {
            return  productRepository.findAllProducts(PageRequest.of(page, size));
        }catch (Exception e){
            e.printStackTrace();
            throw new AbstractGlopalException("Failed to load all Products");
        }
    }


    @Override
    public ProductDto save(ProductDto productDto) {
        try {
            Product  product=(Product) MapperUtil.mapEntityDTO(productDto,Product.class);
            productRepository.save(product);
            return productDto;
        }catch (Exception e){
            e.printStackTrace();
            throw new AbstractGlopalException("Failed to save Product");
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            productRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
            throw new AbstractEntityNotFound("Failed to delete Product with Id :"+id);
        }
    }

    @Override
    public void deleteAll(Collection<Long> ids) {
        try {
            productRepository.deleteAllByIdIn(ids);
        }catch (Exception e){
            e.printStackTrace();
            throw new AbstractEntityNotFound("Failed to delete all Product");
        }
    }
}
