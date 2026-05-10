package com.example.reactive.util;

import com.example.reactive.dto.ProductDto;
import com.example.reactive.entity.Product;
import org.springframework.beans.BeanUtils;

public class AppUtility {

    public static ProductDto entityToDto(Product product) {
        ProductDto dto = ProductDto.builder().build();
        BeanUtils.copyProperties(product, dto);
        return dto;
    }

    public static Product dtoToEntity(ProductDto productDto) {
        Product entity = Product.builder().build();
        BeanUtils.copyProperties(productDto, entity);
        return entity;
    }
}
