package shoppingList.service;

import org.junit.Before;
import shoppingList.domain.Product;
import shoppingList.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Captor;
import shoppingList.service.validation.ProductValidationService;

import java.math.BigDecimal;
import java.util.Optional;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {
    @Mock
    private ProductRepository repository;
    @Mock
    private ProductValidationService validationService;

    @Captor
    private ArgumentCaptor<Product> productCaptor;
    private ProductService victim;

    @Before
    public  void setBefore() throws Exception {
        victim = new DefaultProductService(repository, validationService);
    }

    @Test
    public void ShouldCreateProductSuccessful() {
        Product product = new Product();
        when(repository.insert(product)).thenReturn(product);
        Product result = victim.createProduct(product);
        verify(validationService).validate(productCaptor.capture());
        Product captorResult = productCaptor.getValue();
        assertEquals(captorResult, product);
        assertEquals(product.getId(), result.getId());
    }

    @Test
    public void ShouldFindProductById() {
        when(repository.findProductById(1001L)).thenReturn(Optional.of(product()));
        Product result = victim.findProductById(1001L);
        assertEquals(product(), result);
    }

       private Product product() {
        Product product = new Product();
        product.setName("VICTIM");
        product.setPercent(new BigDecimal("10.6"));
        product.setPrice(new BigDecimal("20"));
        product.setId(1001L);
        return product;
    }
}