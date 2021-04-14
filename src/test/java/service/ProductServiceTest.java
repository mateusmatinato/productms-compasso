package service;

import com.compasso.productms.entity.ProductEntity;
import com.compasso.productms.repository.ProductRepository;
import com.compasso.productms.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceTest {

    private ProductService service;
    private ProductRepository repository;

    @BeforeEach
    public void config() {
        repository = Mockito.mock(ProductRepository.class);
        service = new ProductService();
    }

    @Test
    public void testListProducts() {
        Mockito.when(repository.findAll()).thenReturn(mockProductEntity(10));
        Assertions.assertEquals(10, service.listProducts().size());
    }

    private List<ProductEntity> mockProductEntity(int qtd) {
        List<ProductEntity> products = new ArrayList<>();
        for (int i = 0; i < qtd; i++) {
            ProductEntity productEntity = new ProductEntity();
            productEntity.setId((long) i);
            productEntity.setPrice(BigDecimal.valueOf((long) i * 10));
            productEntity.setName(String.format("Product - %s", i));
            productEntity.setDescription("Description");
            products.add(productEntity);
        }
        return products;
    }

}
