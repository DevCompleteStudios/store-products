package com.devstudos.store.app.products.presentation.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.devstudos.store.app.products.application.dtos.products.CreateProductDto;
import com.devstudos.store.app.products.application.dtos.shared.PaginationDto;
import com.devstudos.store.app.products.application.services.ProductsService;

import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.devstudos.store.app.products.application.dtos.products.UpdateProductDto;





@RestController
public class ProductsController {
    
    @Autowired
    private ProductsService service;

    @GetMapping
    public Mono<ResponseEntity<?>> findAll( @Validated @ModelAttribute Mono<PaginationDto> dto ) {
        return service.findAll(dto)
            .map( r -> ResponseEntity.status(r.getStatus()).body(r));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<?>> findById(@PathVariable String id){
        return service.findById(id)
            .map( r -> ResponseEntity.status(r.getStatus()).body(r));
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<?>> deleteById(@PathVariable String id){
        return service.deleteById(id)
            .map(r -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<?>> updateById( @PathVariable String id, @Validated @RequestBody Mono<UpdateProductDto> dto ){
        return service.update(id, dto)
            .map(r -> ResponseEntity.status(r.getStatus()).body(r));
    }

    @PostMapping()
    public Mono<ResponseEntity<?>> create( @Validated @RequestBody Mono<CreateProductDto> dto ){
        return service.create(dto)
            .map( r -> ResponseEntity.status(r.getStatus()).body(r));
    }
    

}
