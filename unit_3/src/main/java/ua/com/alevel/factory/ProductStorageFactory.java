package ua.com.alevel.factory;

import ua.com.alevel.db.DbProduct;
import ua.com.alevel.db.ProductStorage;

public class ProductStorageFactory {
    private final static ProductStorage productStorage =  new DbProduct();

    public static ProductStorage getProductStorage() {
        return productStorage;
    }
}