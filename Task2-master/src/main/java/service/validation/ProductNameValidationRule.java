package service.validation;

import domain.Product;

public class ProductNameValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        checkNotNull(product);
        if (product.getName() != null || product.getPercent() != null || product.getPrice() != null) {

            if (product.getName().length() < 3 || product.getName().length() > 32) {
                throw new ProductValidationException("Name is incorrect. Please insert new name, more than 2" +
                        " and less than 33 symbols.");
            }
        }
    }
}
