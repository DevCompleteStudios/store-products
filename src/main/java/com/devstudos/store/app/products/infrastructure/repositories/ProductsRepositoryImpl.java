package com.devstudos.store.app.products.infrastructure.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.devstudios.store.app.commons.entities.Product;
import com.devstudos.store.app.products.application.interfaces.repositories.IProductsRepository;
import com.devstudos.store.app.products.domain.errors.CustomException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Repository
public class ProductsRepositoryImpl implements IProductsRepository {

    @Autowired
    ProductsRepositoryReactive reactive;


    @Override
    @Transactional(readOnly = true)
    public Flux<Product> findAll(Pageable pageable) {
        return reactive.findAll(pageable);
    }

    @Override
    @Transactional
    public Mono<Product> save(Product product) {
        return reactive.save(product);
    }

    @Override
    @Transactional(readOnly = true)
    public Mono<Product> findById(String id) {
        return reactive.findById(id)
            .switchIfEmpty(Mono.error(CustomException.notFound("Product not found")));
    }

    @Override
    @Transactional(readOnly = true)
    public Mono<Long> countAll() {
        return reactive.count();
    }

    @Override
    @Transactional
    public Mono<Void> deleteById(String id) {
        return reactive.deleteById(id);
    }

}
