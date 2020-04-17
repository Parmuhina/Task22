package service.validation;

import domain.Product;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Assert;

public class ProductNameValidationRuleTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();
    private ProductNameValidationRule victim = new ProductNameValidationRule();
    private Product input;

    @Test
    public void shouldNotThrowProductValidationException() {
        Assert.assertEquals("milk", product("milk").getName());
    }

    @Test
    public void shouldThrowProductValidationExceptionLess2() {
        input = product("a");
        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Name is incorrect. Please insert new name, more than 2 and" +
                " less than 33 symbols.");
        victim.validate(input);
    }

    @Test
    public void shouldThrowProductValidationExceptionMore32() {
        input = product("alphabet_alphabet_alphabet_alphabet_alphabet");
        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Name is incorrect. Please insert new name, more than 2 and" +
                " less than 33 symbols.");
        victim.validate(input);
    }

    @Test
    public void shouldThrowProductValidationExceptionMoreNull() {
        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Must be not null");
        victim.validate(null);
    }

    private Product product(String name) {
        Product product = new Product();
        product.setName(name);
        return product;
    }
}