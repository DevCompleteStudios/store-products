package com.devstudos.store.app.products.infrastructure.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.devstudos.store.app.products.application.interfaces.repositories.IProductsRepository;
import com.devstudos.store.app.products.domain.entities.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Repository
public class ProductsRepositoryImpl implements IProductsRepository {

    @Autowired
    ProductsRepositoryReactive reactive;


    @Override
    @Transactional(readOnly = true)
    public Flux<Product> findAll(Pageable pageable) {
        return reactive.findAll();
    }

    @Override
    @Transactional
    public Mono<Product> save(Product product) {
        return reactive.save(product);
    }

    @Override
    @Transactional(readOnly = true)
    public Mono<Product> findById(String id) {
        return reactive.findById(id);
    }
    
}
