package shoppingList.service;

import org.springframework.beans.factory.annotation.Autowired;
import shoppingList.domain.Product;
import org.springframework.stereotype.Component;
import shoppingList.repository.ProductRepository;
import shoppingList.service.validation.ProductValidationService;

@Component
public class Service {

    private final ProductRepository repository;
    private final ProductValidationService validationService;

    @Autowired
    public Service (ProductRepository repository, ProductValidationService productValidationService){
        this.repository=repository;
        this.validationService = productValidationService;
    }

    public Long createProduct(Product product){
        validationService.validate(product);
        Product createdProduct= repository.insert(product);
        return createdProduct.getId();
    }

    public Product findProductById (Long id){
        return repository.findProductById(id);
    }

    public Product deleteProductById (Long id){
        return repository.deleteProductById(id);
    }
}
