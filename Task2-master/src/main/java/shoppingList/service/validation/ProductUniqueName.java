package shoppingList.service.validation;

import org.springframework.beans.factory.annotation.Autowired;
import shoppingList.domain.Product;
import org.springframework.stereotype.Component;
import shoppingList.repository.ProductRepository;

@Component
public class ProductUniqueName implements ProductValidationRule {
   private final ProductRepository repository;

   @Autowired
   public ProductUniqueName (ProductRepository repository){
       this.repository=repository;
   }
        @Override
        public void validate (Product product){
        checkNotNull(product);
        boolean unique = repository.existsByName(product.getName());
        if (unique == true) {
            throw new ProductValidationException("Task name must be unique.");
        }

    }
    }

