package shoppingList.service.validation;

import shoppingList.domain.Product;
import org.springframework.stereotype.Component;
import shoppingList.repository.ProductRepository;
@Component
public class ProductUniqueName implements ProductValidationRule {
    ProductRepository repository = new ProductRepository();

        @Override
        public void validate (Product product){
        checkNotNull(product);
        boolean unique = repository.existsByName(product.getName());
        if (unique == true) {
            throw new ProductValidationException("Task name must be unique.");
        }

    }
    }

