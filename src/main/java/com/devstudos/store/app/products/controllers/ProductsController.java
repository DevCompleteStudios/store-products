package com.devstudos.store.app.products.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;





@RestController
public class ProductsController {

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(null);
    }
    

}
