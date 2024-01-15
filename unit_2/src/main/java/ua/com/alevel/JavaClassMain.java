package ua.com.alevel;

import ua.com.alevel.howework.Homework_1_1;
import ua.com.alevel.howework.Homework_1_2;
import ua.com.alevel.howework.Homework_1_3;

import java.io.IOException;

public class JavaClassMain {

    public static void main(String[] args) throws IOException {
        Homework_1_1 homework_1_1 = new Homework_1_1();
        Homework_1_2 homework_1_2 = new Homework_1_2();
        Homework_1_3 homework_1_3 = new Homework_1_3();

        homework_1_1.countNumbers();
        homework_1_2.getOccurringChar();
        homework_1_3.countLessonTimeEnd();
    }
}

