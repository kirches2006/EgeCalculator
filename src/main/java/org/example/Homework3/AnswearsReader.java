package org.example.Homework3;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
@Repository
public class AnswearsReader {
    public Map<Integer, String> getAnswears(String filePath) {
        Map<Integer, String> answears = new HashMap<>();
        File file = new File(filePath);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("-");
                if (parts.length == 2) {
                    int number = Integer.parseInt(parts[0].trim());
                    String ans = parts[1].trim();
                    answears.put(number, ans);
                }
            }

            return answears;

        } catch (IOException e) {
            throw new RuntimeException("Ошибка при чтении файла: " + filePath, e);
        }
    }
}

