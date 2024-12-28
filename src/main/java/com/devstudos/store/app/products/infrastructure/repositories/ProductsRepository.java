package com.devstudos.store.app.products.infrastructure.repositories;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.devstudos.store.app.products.domain.entities.Product;



public interface ProductsRepository extends ReactiveMongoRepository<Product, String> {}
