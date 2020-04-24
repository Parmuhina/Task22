package shoppingList.service.validation;

import org.junit.Assert;
import org.junit.Test;
import shoppingList.domain.Product;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import java.math.BigDecimal;

public class ProductPercentValidationRuleTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();
    private ProductPercentValidationRule victim = new ProductPercentValidationRule();
    private Product input;

    @Test
    public void shouldThrowPercentValidationExceptionLessThan0() {
        input = product(new BigDecimal("-1"));
        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Percent is not correct. Please enter percent that is more than 0" +
                " and less or equal to 100.");
        victim.validate(input);
    }
    @Test
    public void shouldThrowPercentValidationExceptionMoreThan100() {
        input = product(new BigDecimal("120"));
        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Percent is not correct. Please enter percent that is more than 0" +
                " and less or equal to 100.");
        victim.validate(input);
    }

    @Test
    public void shouldThrowPercentValidationExceptionNull() {
        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Must be not null");
        victim.validate(null);
    }
    @Test
    public void shouldNotThrowPercentValidationException() {
        Assert.assertEquals(new BigDecimal("10.3"), product(new BigDecimal("10.3")).getPercent());
    }

    private Product product(BigDecimal percent) {
        Product product = new Product();
        product.setPercent(percent);
        return product;
    }
}