package com.devstudos.store.app.products.application.dtos.products;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import com.devstudios.store.app.commons.interfaces.enums.ProductType;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;




public class CreateProductDto {

    @Length(min = 5, max = 50)
    @NotNull
    private String name;

    @NotNull
    @Max(value = 999)
    @Min(value = 0)
    private Double price;

    @NotNull
    @Length(min = 10, max = 1000)
    private String description;

    private MultipartFile image;
    private Boolean isActive = true;

    @Min(value = 0)
    @Max(value = Long.MAX_VALUE)
    private Long stock = 999L;
    private ProductType productType = ProductType.ANY;


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public MultipartFile getImage() {
        return image;
    }
    public void setImage(MultipartFile image) {
        this.image = image;
    }
    public Boolean getIsActive() {
        return isActive;
    }
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
    public Long getStock() {
        return stock;
    }
    public void setStock(Long stock) {
        this.stock = stock;
    }
    public ProductType getProductType() {
        return productType;
    }
    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
    
}
