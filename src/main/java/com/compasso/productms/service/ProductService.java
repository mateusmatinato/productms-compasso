package com.compasso.productms.service;

import com.compasso.model.Product;
import com.compasso.model.ProductData;
import com.compasso.productms.entity.ProductEntity;
import com.compasso.productms.exception.GenericException;
import com.compasso.productms.exception.ProductNotFoundException;
import com.compasso.productms.repository.ProductRepository;
import com.compasso.productms.specifications.ProductEspecifications;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.compasso.productms.mapper.ProductMapper.getProductEntity;
import static com.compasso.productms.mapper.ProductMapper.getProductFromEntity;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product createProduct(ProductData productData) {
        ProductEntity productEntity = getProductEntity(productData);
        productEntity = repository.save(productEntity);
        log.info(String.format("Product -> %s", productEntity));
        return getProductFromEntity(productEntity);
    }

    public List<Product> listProducts() {
        List<Product> products = new ArrayList<>();
        repository.findAll().forEach(productEntity -> products.add(getProductFromEntity(productEntity)));
        return products;
    }

    public Product updateProduct(Long id, ProductData productNew) {
        ProductEntity productOld = repository.findById(id).orElseThrow(ProductNotFoundException::new);
        ProductEntity productMerged = mergeProductNewWithOld(productNew, productOld);

        log.info(String.format("Product -> %s", productMerged));
        return getProductFromEntity(productMerged);
    }

    private ProductEntity mergeProductNewWithOld(ProductData productData, ProductEntity productEntity) {
        productEntity.setName(productData.getName());
        productEntity.setDescription(productData.getDescription());
        productEntity.setPrice(productData.getPrice());
        productEntity = repository.save(productEntity);
        return productEntity;
    }

    public void deleteProduct(Long id) {
        this.findProductById(id);
        repository.deleteById(id);
    }

    public Product findProductById(Long id) {
        ProductEntity productEntity = repository.findById(id).orElseThrow(ProductNotFoundException::new);
        return getProductFromEntity(productEntity);
    }

    public List<Product> listFilteredProducts(String q, BigDecimal minPrice, BigDecimal maxPrice) {
        try {
            Specification<ProductEntity> filters = Specification.where(ProductEspecifications.containsNameOrDescription(q))
                    .and(ProductEspecifications.validateMinPrice(minPrice)).and(ProductEspecifications.validateMaxPrice(maxPrice));

            List<Product> products = new ArrayList<>();
            repository.findAll(filters).forEach(productEntity -> products.add(getProductFromEntity(productEntity)));
            return products;
        }
        catch(Exception e){
            throw new GenericException(e);
        }
    }
}
