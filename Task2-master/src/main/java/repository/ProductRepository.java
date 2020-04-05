package repository;

import domain.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductRepository {
    private Long productIdSequence = 0L;
    private Map<Long, Product> products = new HashMap<>();

    public Product insert(Product product) {
        product.setId(productIdSequence++);
        products.put(product.getId(), product);
        return product;
    }

    public boolean existsByName(String name) {
        return products.values().stream()
                .anyMatch(product -> product.getName().equalsIgnoreCase(name));
    }

    public Product findProductById(Long id) {
        return products.get(id);
    }

    public Product deleteProductById(Long id) {
        return products.remove(id);
    }
}
