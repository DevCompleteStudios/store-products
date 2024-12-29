package com.devstudos.store.app.products.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devstudos.store.app.products.application.dtos.products.CreateProductDto;
import com.devstudos.store.app.products.application.dtos.shared.PaginationDto;
import com.devstudos.store.app.products.application.dtos.shared.ResponseDto;
import com.devstudos.store.app.products.application.dtos.shared.ResponsePagination;
import com.devstudos.store.app.products.application.interfaces.repositories.IProductsRepository;
import com.devstudos.store.app.products.domain.entities.Product;

import reactor.core.publisher.Mono;


@Service
public class ProductsService {

    @Autowired
    IProductsRepository productsRepository;


    public Mono<ResponseDto<?>> create( Mono<CreateProductDto> product ){
        return product
            .flatMap( p -> {
                Product newProduct = new Product(p.getName(), p.getPrice(), p.getDescription(), "http://image/here", p.getIsActive(), p.getProductType(), p.getStock());
                return productsRepository.save(newProduct);
            })
            .map( np -> new ResponseDto<>(200, np));
    }

    public Mono<ResponsePagination<Product>> findAll(Mono<PaginationDto> paginationDto){
        return paginationDto
            .flatMap( r -> {
                Pageable pageable = PageRequest.of(r.getLimit(), r.getOffset());

                return productsRepository.findAll(pageable)
                    .collectList()
                    .map(products -> {
                        ResponsePagination<Product> res = new ResponsePagination<>();

                        res.setCountElements(products.size());
                        res.setData(products);
                        res.setPages(pageable.getOffset());
                        res.setStatus(200);
                        return res;
                    });
            });
    }

}
