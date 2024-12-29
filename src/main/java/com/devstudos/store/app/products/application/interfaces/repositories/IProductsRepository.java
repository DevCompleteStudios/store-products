package com.devstudos.store.app.products.application.interfaces.repositories;


import org.springframework.data.domain.Pageable;

import com.devstudos.store.app.products.domain.entities.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;




public interface IProductsRepository {
    public Flux<Product> findAll(Pageable pageable);
    public Mono<Product> save( Product product );
    public Mono<Product> findById( String id );
    public Mono<Long> countAll();
}
