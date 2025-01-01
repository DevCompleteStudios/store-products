package com.devstudos.store.app.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.mongodb.config.EnableMongoAuditing;


@SpringBootApplication
@EntityScan({"com.devstudios.store.app.commons.entities.store"})
@EnableMongoAuditing
public class StoreProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreProductsApplication.class, args);
	}

}
