package com.compasso.productms.controller;

import com.compasso.api.ProductsApiDelegate;
import com.compasso.model.Product;
import com.compasso.model.ProductData;
import com.compasso.productms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class ProductController implements ProductsApiDelegate  {

    @Autowired
    private ProductService service;

    @Override
    public ResponseEntity<Product> getProductById(Integer id) {
        return ResponseEntity.ok(service.findProductById(Long.valueOf(id)));
    }

    @Override
    public ResponseEntity<Product> createProduct(ProductData productData) {
        Product product = service.createProduct(productData);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deleteProductById(Integer id) {
        service.deleteProduct(Long.valueOf(id));
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<List<Product>> listProducts() {
        return ResponseEntity.ok(service.listProducts());
    }

    @Override
    public ResponseEntity<List<Product>> listProductsFilter(String q, BigDecimal minPrice, BigDecimal maxPrice) {
        return ResponseEntity.ok(service.listFilteredProducts(q, minPrice, maxPrice));
    }

    @Override
    public ResponseEntity<Product> updateProductById(Integer id, ProductData productData) {
        Product product = service.updateProduct(Long.valueOf(id), productData);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
