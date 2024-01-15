package ua.com.alevel.howework;

//В некоторой школе занятия начинаются в 9:00. Продолжительность урока — 45 минут,
// после 1-го, 3-го, 5-го и т.д. уроков перемена 5 минут, а после 2-го, 4-го, 6-го и т.д.
// — 15 минут.


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Homework_1_3 {
    public static void countLessonTimeEnd() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("HW #3. Please enter the numeracy of the lesson. From 1 to 10");
        lessonCounter(reader);
    }

    static void lessonCounter(BufferedReader reader) throws IOException {
        int inputValue = Integer.parseInt(reader.readLine());
        int start = 540;
        int duration = 45;
        int brakes[] = { 0, 5, 20, 25, 40, 45, 60, 65, 80, 85, 100 };
        int brake = brakes[inputValue - 1];
        int sum = start + (duration * inputValue) + brake;
        int hours = sum / 60;
        int minutes = sum % 60;

        System.out.println("The lesson will end at: " + hours + " " + minutes);
    }
}