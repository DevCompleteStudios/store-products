package com.devstudos.store.app.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class StoreProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreProductsApplication.class, args);
	}

}
