package ua.com.alevel.howework;

//2. реализуйте задачу, которая принимает строку с консоли и вычленяет все символы латиницы/кириллицы и сортирует их,
// указывая количество вхождений каждого символа

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Homework_1_2 {
    static final int MAX_CHAR = 256;
    public static void getOccurringChar() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("HW #2. Please enter your string here");
        sumInput(reader);
    }

    static void sumInput(BufferedReader reader) throws IOException {
        int count[] = new int[MAX_CHAR];

        String str = reader.readLine();
        int len = str.length();

        for (int i = 0; i < len; i++)
            count[str.charAt(i)]++;

        char ch[] = new char[str.length()];
        for (int i = 0; i < len; i++) {
            ch[i] = str.charAt(i);
            int find = 0;

            for (int j = 0; j <= i; j++) {
                if (str.charAt(i) == ch[j])
                    find++;
            }

            if (find == 1)
                System.out.println("Number of Occurrence of " +
                        str.charAt(i) + " is:" + count[str.charAt(i)]);
        }
    }
}
