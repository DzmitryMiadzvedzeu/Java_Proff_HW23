package com.telran.org.homework_23;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class MainApp {
    public static void main(String[] args) {
        Storage<Character> characterStorage = new Storage<>();
        Storage<Integer> numberStorage = new Storage<>();
        String filePath = "C:\\Users\\Fujitsu\\IdeaProjects\\JavaProff\\src\\main\\java\\com\\telran\\org\\homework_23\\homeworkText.txt";
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while ((line = reader.readLine()) != null) {
                for (char c : line.toCharArray()) {
                    if (Character.isLetter(c) || Character.isDigit(c)) {
                        if (Character.isLetter(c)) {
                            characterStorage.addElement(c);
                        } else {
                            int digit = Character.getNumericValue(c);
                            numberStorage.addElement(digit);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }

        writeToFile(characterStorage.getElements(), "C:\\Users\\Fujitsu\\IdeaProjects\\JavaProff\\src\\main\\java\\com\\telran\\org\\homework_23\\customHash.txt");
        writeToFile(numberStorage.getElements(), "C:\\Users\\Fujitsu\\IdeaProjects\\JavaProff\\src\\main\\java\\com\\telran\\org\\homework_23\\customNumbers.txt");
    }

    private static <T> void writeToFile(Map<T, Integer> elements, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Map.Entry<T, Integer> entry : elements.entrySet()) {
                writer.write(entry.getKey() + String.valueOf(entry.getValue()));
            }
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
}
