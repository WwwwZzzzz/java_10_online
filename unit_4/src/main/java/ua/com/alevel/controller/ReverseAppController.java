package ua.com.alevel.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseAppController {
    public void start() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        menu();
        String position = "";
        while ((position = reader.readLine()) != null) {
            app(position, reader);
            menu();
        }
    }

    void menu() {
        System.out.println();
        System.out.println("===========================MENU===========================");
        System.out.println("Press 1 for simple reverse");
        System.out.println("Press 2 for reverse part of the string");
        System.out.println("Press 3 for complex reverse by symbol, index. string or char");
        System.out.println("Press q to exit");
        System.out.println("===========================END===========================");
        System.out.println();
    }

    void app(String position, BufferedReader reader) throws IOException {
        switch (position) {
            case "1" -> simpleReverse(reader);
            case "2" -> partialReverse(reader);
            case "3" -> complexReverse(reader);
            case "q" -> System.exit(0);
        }
    }

    void simpleReverse(BufferedReader reader) throws IOException {
        String reverseInput = "";
        System.out.println("Please enter the string you want to reverse");
        String inputValue = reader.readLine();
        for (int i = 0; i < inputValue.length(); i++) {
            char character = inputValue.charAt(i);
            reverseInput = character + reverseInput;
        }
        System.out.println("Reversed string: " + reverseInput);
    }

    void partialReverse(BufferedReader reader) throws IOException {
        String reversePart = "";
        System.out.println("Please enter the string");
        String stringValue = reader.readLine();
        System.out.println("Your string: " + stringValue);
        System.out.println("Please enter the part of the string you want to reverse");
        String partToReverse = reader.readLine();
        boolean isContainWord = stringValue.contains(partToReverse);
        if (isContainWord) {
            for (int i = 0; i < partToReverse.length(); i++) {
                char character = partToReverse.charAt(i);
                reversePart = character + reversePart;
            }
            String partialReversedString = stringValue.replace(partToReverse, reversePart);
            System.out.println("Partial reversed string: " + partialReversedString);
        } else {
            System.out.println("Your part doesn't exist in the string");
        }
    }

    void complexReverse(BufferedReader reader) throws IOException {
        String reversePart = "";
        System.out.println("Please enter the string");
        String stringValue = reader.readLine();
        System.out.println("Your string: " + stringValue);
        System.out.println("Please enter the first index you want to start reverse with");
        int firstIndex = Integer.parseInt(reader.readLine());
        System.out.println("Please enter the last index you want to end reverse with");
        int lastIndex = Integer.parseInt(reader.readLine());

        if ((firstIndex >= 0 && firstIndex < stringValue.length()) &&
                (lastIndex > 0 && lastIndex <= stringValue.length()) &&
                firstIndex < lastIndex) {
            String indexRange = stringValue.substring(firstIndex, lastIndex + 1);
            for (int i = 0; i < indexRange.length(); i++) {
                char character = indexRange.charAt(i);
                reversePart = character + reversePart;
            }
            String partialReversedString = stringValue.replace(indexRange, reversePart);
            System.out.println("indexRange "  + indexRange);
            System.out.println("reversePart: " + reversePart);
            System.out.println("Reversed string from index range: " + partialReversedString);
        } else {
            System.out.println("One of your indexes are incorrect");
        }
    }
}
