package shoppingList.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shoppingList.domain.Product;
import shoppingList.repository.ProductRepository;
import shoppingList.service.validation.ProductValidationService;


@Service
public class DefaultProductService implements ProductService {

    private final ProductRepository repository;
    private final ProductValidationService validationService;

    @Autowired
    public DefaultProductService(ProductRepository repository,
                              ProductValidationService validationService) {
        this.repository = repository;
        this.validationService = validationService;
    }

    @Transactional
    public Product createProduct (Product product) {
        validationService.validate(product);
        return repository.insert(product);
    }

    public Product findProductById (Long id) {
        return repository.findProductById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found, id: " + id));
    }

    @Override
    public void deleteProductById(Long id) {
        Product product = repository.findProductById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found, id: " + id));
        repository.deleteProductById(product);

    }

    @Override
    public void change (Long id, Product product1) {
        Product product = repository.findProductById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found, id: " + id));

        product.setName(product1.getName());
        product.setPrice(product1.getPrice());
        product.setCategory(product1.getCategory());
        product.setPercent(product1.getPercent());

        repository.change(product);
    }
}
