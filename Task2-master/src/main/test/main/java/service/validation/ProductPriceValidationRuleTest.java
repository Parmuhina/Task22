package service.validation;

import org.junit.Assert;
import org.junit.Test;
import domain.Product;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import java.math.BigDecimal;

public class ProductPriceValidationRuleTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();
    private ProductPriceValidationRule victim = new ProductPriceValidationRule();
    private Product input;

    @Test
    public void shouldThrowPriceValidationExceptionLessOrEqual0() {
        input = product(new BigDecimal("-5"));
        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Price is not correct. Please enter price that is more than 0.");
        victim.validate(input);
    }

    @Test
    public void shouldThrowPriceValidationExceptionLessOrEqualsNull() {
        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Must be not null");
        victim.validate(null);
    }

    @Test
    public void shouldNotThrowPriceValidationException() {
        Assert.assertEquals(new BigDecimal("20.1"), product(new BigDecimal("20.1")).getPrice());
    }

    private Product product(BigDecimal price) {
        Product product = new Product();
        product.setPrice(price);
        return product;
    }
}