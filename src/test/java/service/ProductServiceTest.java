package service;

import com.compasso.model.Product;
import com.compasso.model.ProductData;
import com.compasso.productms.entity.ProductEntity;
import com.compasso.productms.repository.ProductRepository;
import com.compasso.productms.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Test
    public void testDeleteProduct() {
        Mockito.when(repository.findById(1L)).thenReturn(Optional.ofNullable(mockProductEntity(1).get(0)));
        Mockito.doNothing().when(repository).deleteById(1L);
        service.deleteProduct(1L);
    }

    private List<ProductData> mockProductData(int qtd) {
        List<ProductData> products = new ArrayList<>();
        for (int i = 0; i < qtd; i++) {
            ProductData productData = new ProductData();
            productData.setPrice(BigDecimal.valueOf((long) i * 10));
            productData.setName(String.format("Product - %s", i));
            productData.setDescription("Description");
            products.add(productData);
        }
        return products;
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
