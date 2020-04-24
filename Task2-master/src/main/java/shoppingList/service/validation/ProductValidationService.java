package shoppingList.service.validation;

import org.springframework.beans.factory.annotation.Autowired;
import shoppingList.domain.Product;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
@Component
public class ProductValidationService {

    private final Set<ProductValidationRule> validationRules;
@Autowired
public ProductValidationService(Set<ProductValidationRule> validationRules){
    this.validationRules=validationRules;
}

    public void validate(Product product) {
        validationRules.forEach(s -> s.validate(product));
    }

    }
