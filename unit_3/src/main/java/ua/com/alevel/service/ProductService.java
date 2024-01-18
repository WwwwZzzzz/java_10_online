package ua.com.alevel.service;

import ua.com.alevel.db.ProductStorage;
import ua.com.alevel.entity.Product;
import ua.com.alevel.factory.ProductStorageFactory;

// SERVICE CLASS
public class ProductService {
    ProductStorage productStorage = ProductStorageFactory.getProductStorage();

    public void createProduct(Product product) {
        if (product.getProductName() != null && product.getProductPrice() > 0) {
            productStorage.createProduct(product);
        }
    }

    public void updateProduct(Product product) {
        Product current = productStorage.findProductById(product.getId());
        if (current != null) {
            productStorage.updateProduct(product);
        }
    }

    public void deleteProduct(int id) {
        Product current = productStorage.findProductById(id);
        if (current != null) {
            productStorage.deleteProduct(id);
        }
    }

    public Product[] findAllProducts() {
        return productStorage.findAllProducts();
    }

    public Product findProductById(int id) {
        return productStorage.findProductById(id);
    }
}