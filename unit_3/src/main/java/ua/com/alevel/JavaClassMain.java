package ua.com.alevel;

import ua.com.alevel.controller.ProductController;

import java.io.IOException;

public class JavaClassMain {

    public static void main(String[] args) throws IOException {
        ProductController productController = new ProductController();
        productController.start();
    }
}

