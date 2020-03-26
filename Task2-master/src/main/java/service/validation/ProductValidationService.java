package service.validation;

import domain.Product;
import java.util.HashSet;
import java.util.Set;

public class ProductValidationService {

    private Set<ProductValidationRule> validationRules = new HashSet<>();
    private Set<ProductValidationPercentRule> validationPercentRules = new HashSet<>();
    private Set<ProductValidationPriceRule> validationPriceRules = new HashSet<>();
    private Set<ProductValidationUniqueRule> validationUniqueRules = new HashSet<>();

    public ProductValidationService() {
        validationRules.add(new ProductUniqueName());
        validationPercentRules.add(new ProductPercentValidationRule());
        validationPriceRules.add(new ProductPriceValidationRule());
        validationUniqueRules.add(new ProductUniqueName());
    }

    public void validate(Product product) {
        validationRules.forEach(s -> s.validate(product));
    }

    public void validatePercent(Product product) {
        validationPercentRules.forEach(s -> s.validatePercent(product));
    }

    public void validatePrice(Product product) {
        validationPriceRules.forEach(s -> s.validatePrice(product));
    }

    public void validateUniqueName(Product product) {
        validationUniqueRules.forEach(s -> s.validateUniqueName(product));
    }
}
