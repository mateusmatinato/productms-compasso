package com.compasso.productms.mapper;

import com.compasso.model.Product;
import com.compasso.model.ProductData;
import com.compasso.productms.entity.ProductEntity;

public class ProductMapper {

    public static Product getProductFromEntity(ProductEntity productEntity) {
        return new Product()
                .id(productEntity.getId())
                .description(productEntity.getDescription())
                .name(productEntity.getName())
                .price(productEntity.getPrice());
    }

    public static ProductEntity getProductEntity(ProductData productData) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setDescription(productData.getDescription());
        productEntity.setName(productData.getName());
        productEntity.setPrice(productData.getPrice());
        return productEntity;
    }

}
