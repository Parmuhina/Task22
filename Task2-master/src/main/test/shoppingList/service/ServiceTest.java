package shoppingList.service;

import shoppingList.domain.Product;
import shoppingList.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Captor;
import shoppingList.service.validation.ProductValidationService;

import java.math.BigDecimal;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {
    @Mock
    private ProductRepository repository;
    @Mock
    private ProductValidationService validationService;

    @InjectMocks
    private Service victim;
    @Captor
    private ArgumentCaptor<Product> productCaptor;

    @Test
    public void ShouldCreateProductSuccessful() {
        Product product = new Product();
        when(repository.insert(product)).thenReturn(product);
        Long result = victim.createProduct(product);
        verify(validationService).validate(productCaptor.capture());
        Product captorResult = productCaptor.getValue();
        assertEquals(captorResult, product);
        assertEquals(product.getId(), result);
    }

    @Test
    public void ShouldFindProductByID() {
        when(repository.findProductById(1001L)).thenReturn(product());
        Product result = victim.findProductById(1001L);
        assertEquals(product(), result);
    }

    @Test
    public void deleteProductByID() {
        when(repository.deleteProductById(1001L)).thenReturn(product());
        Product result = victim.deleteProductById(1001L);
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