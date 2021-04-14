package service;

import com.compasso.productms.entity.ProductEntity;
import com.compasso.productms.repository.ProductRepository;
import com.compasso.productms.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @InjectMocks
    private ProductService service;

    @Mock
    private ProductRepository repository;

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
