package com.compasso.productms.controller;


import com.compasso.model.Product;
import com.compasso.model.ProductData;
import com.compasso.productms.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductControllerTest {

    private ProductController controller;
    private ProductService service;

    @BeforeEach
    public void config() {
        service = Mockito.mock(ProductService.class);
        controller = new ProductController();
    }

    @Test
    public void testListProducts() {
        Mockito.when(service.listProducts()).thenReturn(mockProducts(10));

        List<Product> products = controller.listProducts().getBody();
        Assertions.assertNotNull(products);
        Assertions.assertEquals(10, products.size());
    }

    @Test
    public void testInsertNewProduct() {
        Mockito.when(service.createProduct(mockProductData())).thenReturn(mockProducts(1).get(0));

        Product product = controller.createProduct(mockProductData()).getBody();
        Assertions.assertNotNull(product);
    }

    @Test
    public void testUpdateProduct() {
        Mockito.when(service.updateProduct(1L, mockProductData())).thenReturn(mockProducts(1).get(0));

        Product product = controller.updateProductById(1, mockProductData()).getBody();
        Assertions.assertNotNull(product);
    }

    @Test
    public void testDeleteProduct() {
        Mockito.doNothing().when(service).deleteProduct(1L);
        ResponseEntity<Void> responseEntity = controller.deleteProductById(1);
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void testListWithFilter() {
        Mockito.when(service.listFilteredProducts("q", BigDecimal.ONE, BigDecimal.TEN)).thenReturn(mockProducts(5));

        List<Product> products = controller.listProductsFilter("q", BigDecimal.ONE, BigDecimal.TEN).getBody();
        Assertions.assertNotNull(products);
        Assertions.assertEquals(5, products.size());
    }

    private ProductData mockProductData() {
        return new ProductData().description("desc").price(BigDecimal.ONE).name("name");
    }

    private List<Product> mockProducts(int qtd) {
        Random random = new Random();
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < qtd; i++) {
            products.add(new Product().id(1L).name("i").description("i").price(BigDecimal.valueOf(random.nextDouble())));
        }
        return products;
    }

}
