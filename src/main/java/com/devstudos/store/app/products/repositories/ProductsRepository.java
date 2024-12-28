package com.devstudos.store.app.products.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devstudos.store.app.products.entities.ProductEntity;



public interface ProductsRepository extends JpaRepository<ProductEntity, Long> {

}
