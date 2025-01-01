package com.devstudos.store.app.products.application.services;

import java.security.Provider;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devstudios.store.app.commons.entities.Product;
import com.devstudos.store.app.products.application.dtos.products.CreateProductDto;
import com.devstudos.store.app.products.application.dtos.products.UpdateProductDto;
import com.devstudos.store.app.products.application.dtos.shared.PaginationDto;
import com.devstudos.store.app.products.application.dtos.shared.ResponseDto;
import com.devstudos.store.app.products.application.dtos.shared.ResponsePagination;
import com.devstudos.store.app.products.application.interfaces.repositories.IProductsRepository;
import com.devstudos.store.app.products.domain.errors.CustomException;

import reactor.core.publisher.Mono;


@Service
public class ProductsService {

    @Autowired
    IProductsRepository productsRepository;


    public Mono<ResponseDto<?>> create( Mono<CreateProductDto> product ){
        return product
            .flatMap( p -> {
                Product newProduct = new Product();
                newProduct.setName(p.getName());
                newProduct.setPrice(p.getPrice());
                newProduct.setDescription(p.getDescription());
                newProduct.setImage("http://image/here");
                newProduct.setIsActive(p.getIsActive());
                newProduct.setProductType(p.getProductType());
                newProduct.setStock(p.getStock());

                return productsRepository.save(newProduct);
            })
            .map( np -> new ResponseDto<>(200, np));
    }

    public Mono<ResponsePagination<Product>> findAll(Mono<PaginationDto> paginationDto) {
        return paginationDto
            .flatMap(r -> {
                Pageable pageable = PageRequest.of(r.getPage(), r.getLimit());
                Mono<List<Product>> productsMono = productsRepository.findAll(pageable).collectList();
                Mono<Long> countMono = productsRepository.countAll();
                // Mono<Long> countMono = Mono.just(2L);

                return Mono.zip(productsMono, countMono, (products, count) -> {
                    ResponsePagination<Product> res = new ResponsePagination<>();
                    res.setData(products);
                    res.setCountElements(count);
                    res.setStatus(200);
                    res.setMaxPages( Math.ceil( count / r.getLimit() ) );
                    return res;
                });
            });
    }

    public Mono<ResponseDto<Product>> findById( String id ){
        return productsRepository.findById(id)
            .map( r -> {
                ResponseDto<Product> res = new ResponseDto<>();
                res.setData(r);
                res.setStatus(200);

                return res;
            })
            .switchIfEmpty(Mono.error(CustomException.notFound("Product not found")));
    }

    public Mono<Void> deleteById(String id){
        return productsRepository.deleteById(id);
    }

    public Mono<ResponseDto<Product>> update( String id, Mono<UpdateProductDto> dto ){
        return dto
            .flatMap(p -> {
                return productsRepository.findById(id)
                    .switchIfEmpty(Mono.error(CustomException.notFound("Product not exists")))
                    .flatMap( r -> {
                        if(p.getIsActive() != null) r.setIsActive(p.getIsActive());
                        if(p.getDescription() != null) r.setDescription(p.getDescription());
                        if(p.getImage() != null) r.setImage("Image updated");
                        if(p.getName() != null) r.setName(p.getName());
                        if(p.getPrice() != null) r.setPrice(p.getPrice());
                        if(p.getProductType() != null) r.setProductType(p.getProductType());
                        if(p.getStock() != null) r.setStock(p.getStock());
                        r.setUpdatedAt(LocalDateTime.now());

                        return productsRepository.save(r);
                    });
            })
            .map(prd -> new ResponseDto<>(200, prd));
    }


}
