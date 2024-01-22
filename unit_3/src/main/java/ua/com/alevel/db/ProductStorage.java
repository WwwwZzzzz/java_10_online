package ua.com.alevel.db;

import ua.com.alevel.entity.Product;

public interface ProductStorage {
    public abstract void createProduct(Product product);
    public abstract void updateProduct(Product product);
    public abstract void deleteProduct(int id);
    public abstract Product findProductById(int id);
    public abstract Product[] findAllProducts();
}