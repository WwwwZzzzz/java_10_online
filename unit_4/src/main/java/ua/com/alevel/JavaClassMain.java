package ua.com.alevel;

import ua.com.alevel.controller.ReverseAppController;

import java.io.IOException;

public class JavaClassMain {
    public static void main(String[] args) throws IOException {
        ReverseAppController reverseAppController = new ReverseAppController();
        reverseAppController.start();
    }
}
