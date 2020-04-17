package service.validation;

import domain.Product;
import repository.ProductRepository;

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

