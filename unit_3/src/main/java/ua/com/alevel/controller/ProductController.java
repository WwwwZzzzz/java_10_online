package ua.com.alevel.controller;

import ua.com.alevel.entity.Product;
import ua.com.alevel.service.ProductService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProductController {
    private final ProductService productService = new ProductService();

    public void start() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        menu();
        String position = "";
        while ((position = reader.readLine()) != null) {
            crud(position, reader);
            menu();
        }
    }

    void menu() {
        System.out.println("");
        System.out.println("====================MENU====================");
        System.out.println("If you want to add a product to your wishlist please enter 1");
        System.out.println("If you want to see your wishlist please enter 2");
        System.out.println("If you want to update your wishlist please enter 3");
        System.out.println("If you want to find product by id please enter 4");
        System.out.println("If you want to delete product from your wishlist enter 5");
        System.out.println("If you want to exit please enter q");
        System.out.println("====================END====================");
        System.out.println("");
    }

    void crud(String position, BufferedReader reader) throws IOException {
        switch (position) {
            case "1" -> createProduct(reader);
            case "2" -> findAllProducts();
            case "3" -> updateProduct(reader);
            case "4" -> findProductById(reader);
            case "5" -> deleteProduct(reader);
            case "q" -> System.exit(0);
        }
    }

    void createProduct(BufferedReader reader) throws IOException {
        System.out.println("ProductController.createProduct");
        System.out.println("Please enter product name");
        String productName = reader.readLine();
        System.out.println("Please enter product price");
        int productPrice = Integer.parseInt(reader.readLine());
        Product product = new Product();
        product.setProductName(productName);
        product.setProductPrice(productPrice);
        productService.createProduct(product);
    }

    void deleteProduct(BufferedReader reader) throws IOException {
        System.out.println("ProductController.deleteProduct");
        System.out.println("Please enter product id you want to delete");
        String productId = reader.readLine();
        int id = Integer.parseInt(productId);
        productService.deleteProduct(id);
        Product product = productService.findProductById(id);
        if (product == null) {
            System.out.println("Product was deleted successfully");
        }
    }

    void findProductById(BufferedReader reader) throws IOException {
        System.out.println("ProductController.findProductById");
        System.out.println("Please enter id");
        String productId = reader.readLine();
        int id = Integer.parseInt(productId);
        Product product = productService.findProductById(id);
        if (product != null) {
            System.out.println(
                    "Product name: " + product.getProductName() +
                            ", Product price: " + product.getProductPrice());
        } else {
            System.out.println("Product not found");
        }
    }

    void findAllProducts() {
        System.out.println("ProductController.findAllProducts");
        Product[] products = productService.findAllProducts();
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                System.out.println("#: " + i +
                        ", Product name: " + products[i].getProductName() +
                        ", Product price: " + products[i].getProductPrice());
            }
        }
    }

    void updateProduct(BufferedReader reader) throws IOException {
        System.out.println("ProductController.updateProduct");
        System.out.println("Please enter id");
        String productId = reader.readLine();
        int id = Integer.parseInt(productId);
        Product product = productService.findProductById(id);
        if (product != null) {
            System.out.println("Please enter product name");
            String productName = reader.readLine();
            System.out.println("Please enter product price");
            int productPrice = Integer.parseInt(reader.readLine());
            product = new Product();
            product.setProductName(productName);
            product.setProductPrice(productPrice);
            product.setId(id);
            productService.updateProduct(product);
        } else {
            System.out.println("Product not found");
        }
    }
}