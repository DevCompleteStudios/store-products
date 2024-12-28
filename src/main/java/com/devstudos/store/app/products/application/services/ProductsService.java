package com.devstudos.store.app.products.application.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.devstudos.store.app.products.application.dtos.products.CreateProductDto;
import com.devstudos.store.app.products.application.dtos.shared.ResponseDto;
import com.devstudos.store.app.products.application.interfaces.repositories.IProductsRepository;

import reactor.core.publisher.Mono;



public class ProductsService {

    @Autowired
    IProductsRepository productsRepository;


    public Mono<ResponseDto<?>> create( Mono<CreateProductDto> product ){
        return null;
    }

}
