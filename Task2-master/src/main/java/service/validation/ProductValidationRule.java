package service.validation;
import domain.Product;

public interface ProductValidationRule {

    void validate(Product product);
    default void checkNotNull(Product product) {
        if (product == null) {
            throw new ProductValidationException("Product must be not null");
        }
    }
}