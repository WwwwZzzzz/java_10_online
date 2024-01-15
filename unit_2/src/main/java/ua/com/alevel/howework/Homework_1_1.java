package ua.com.alevel.howework;

// 1. реализуйте задачу, которая принимает строку с консоли и вычленяет все числа и находит их сумму
// Пример:
// Входные данные: 1w4tt!7 Выходные данные: 12

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Homework_1_1 {
    public static void countNumbers() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("HW #1. Please enter your string with digits here");
        sumInput(reader);
    }

    static void sumInput(BufferedReader reader) throws IOException {
        String inputValue = reader.readLine();
        Input input = new Input();
        input.inputValue = inputValue;
        int sum= 0;

        String allDigit = inputValue.replaceAll("[^0-9]", "");

        for (int i = 0; i < allDigit.length(); i++) {
            int res = Character.digit(allDigit.charAt(i), 10);
            sum += res;
        }
        System.out.println("The sum is: " + sum);
    }
}

