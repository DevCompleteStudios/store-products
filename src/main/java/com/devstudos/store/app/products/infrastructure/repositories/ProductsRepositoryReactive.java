package com.devstudos.store.app.products.infrastructure.repositories;


import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.devstudios.store.app.commons.entities.Product;

import reactor.core.publisher.Flux;



public interface ProductsRepositoryReactive extends ReactiveMongoRepository<Product, String> {
    @Query("{}")
    public Flux<Product> findAll(Pageable pageable);
}
