package ua.com.alevel.db;

import ua.com.alevel.entity.Product;

public class DbProduct implements ProductStorage {
    private Product[] products = new Product[10];

    public void createProduct(Product product) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                product.setId(i);
                break;
            }
        }
    }

    public void updateProduct(Product product) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null && products[i].getId() == product.getId()) {
                products[i] = product;
                break;
            }
        }
    }

    public void deleteProduct(int id) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null && products[i].getId() == id) {
                products[i] = null;
            }
        }
    }

    public Product[] findAllProducts() {
        return products;
    }

    public Product findProductById(int id) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null && products[i].getId() == id) {
                return products[i];
            }
        }
        return null;
    }
}
