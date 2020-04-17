package service;

import domain.Product;
import repository.ProductRepository;
import service.validation.ProductValidationService;

public class Service {

    private ProductRepository repository = new ProductRepository();
    private ProductValidationService validationService = new ProductValidationService();

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

    public Boolean existsByName (String name){
        return repository.existsByName(name);
    }
}
