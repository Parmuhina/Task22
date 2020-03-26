package service.validation;
import domain.Product;
import repository.ProductRepository;

public class ProductUniqueName implements ProductValidationUniqueRule {

  // private final ProductRepository repository;

//    //public ProductUniqueName(ProductRepository repository) {
//        this.repository = repository;
//    }

    @Override
    public void validateUniqueName(Product product) {
        checkNotNull(product);
        if () {
            throw new ProductValidationException("Task name must be unique.");
        }
    }

}
