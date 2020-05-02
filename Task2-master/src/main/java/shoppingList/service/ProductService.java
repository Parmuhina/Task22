package shoppingList.service;

import shoppingList.domain.Product;

public interface ProductService {

        Product createProduct(Product product);

        Product findProductById(Long id);

        void deleteProductById(Long id);

        void change (Long id, Product product);
}
