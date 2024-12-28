package com.devstudos.store.app.products.presentation.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
public class ProductsController {

    @GetMapping
    public ResponseEntity<?> findAll() {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id){
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id){
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateById( @PathVariable String id ){
        return null;
    }

    @PostMapping()
    public ResponseEntity<?> create(){
        return null;
    }
    

}
