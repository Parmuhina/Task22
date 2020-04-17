package service.validation;
import domain.Product;

public interface ProductValidationRule {

    void validate(Product product);
    default void checkNotNull(Product product) {
        if (product == null) {
            throw new ProductValidationException("Must be not null");
        }
    }
}
