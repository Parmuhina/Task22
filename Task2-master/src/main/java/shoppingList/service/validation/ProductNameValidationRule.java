package shoppingList.service.validation;

import shoppingList.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductNameValidationRule implements ProductValidationRule {
    final int minLength=3;
    final int maxLength=32;

    @Override
    public void validate(Product product) {
        checkNotNull(product);
        if (product.getName().length() < minLength || product.getName().length() > maxLength) {
            throw new ProductValidationException("Name is incorrect. Please insert new name, more than 2" +
                    " and less than 33 symbols.");
        }
    }
}
