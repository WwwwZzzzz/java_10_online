package ua.com.alevel;


import ua.com.alevel.controller.StudentGroupController;
import java.io.IOException;

public class JavaClassMain {

    public static void main(String[] args) throws IOException {

        StudentGroupController studentGroupController = new StudentGroupController();
        studentGroupController.start();
    }
}