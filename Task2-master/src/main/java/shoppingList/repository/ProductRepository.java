package shoppingList.repository;

import shoppingList.domain.Product;
import java.util.Optional;

    public interface ProductRepository {

    Product insert (Product product);
    Optional <Product> findProductById (Long id);
    boolean existsByName (String name);
    void deleteProductById (Product product);
    void change (Product product);
}
