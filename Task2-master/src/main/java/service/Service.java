package service;

import domain.Product;
import repository.ProductRepository;
import service.validation.ProductValidationService;

public class Service {

    private ProductRepository repository = new ProductRepository();
    private ProductValidationService validationService = new ProductValidationService();


    public Long createProduct(Product product){
        validationService.validate(product);
        validationService.validatePrice(product);
        validationService.validatePercent(product);


        Product createdProduct= repository.insert(product);

        return createdProduct.getId();
    }

    public Product findProductById (Long id){
        return repository.findProductById(id);
    }
}
