package com.example.reactive.service;

import com.example.reactive.dto.ProductDto;
import com.example.reactive.entity.Product;
import com.example.reactive.repository.ProductRepository;
import com.example.reactive.util.AppUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public Flux<ProductDto> getProducts() {
        return repository.findAll().map(AppUtility::entityToDto);
    }

    public Mono<ProductDto> getProduct(String id) {
        return repository.findById(id).map(AppUtility::entityToDto);
    }

    public Flux<ProductDto> getProductsInRange(Double min, Double max) {
        return repository.findByPriceBetween(Range.closed(min, max));
    }

    public Mono<ProductDto> saveProduct(Mono<ProductDto> productDtoMono) {
        return productDtoMono
                .map(AppUtility::dtoToEntity)
                .flatMap(repository::insert)
                .map(AppUtility::entityToDto);
    }

    public Mono<ProductDto> updateProduct(String id, Mono<ProductDto> productDtoMono) {
        return repository.findById(id)
                .flatMap(fromDto -> productDtoMono.map(AppUtility::dtoToEntity))
                .doOnNext(fromDto -> fromDto.setId(id))
                .flatMap(repository::save)
                .map(AppUtility::entityToDto);
    }

    public Mono<Void> deleteProduct(String id) {
        return repository.deleteById(id);
    }
}
