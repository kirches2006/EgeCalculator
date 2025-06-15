package org.example.Homework3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ResultsProcessor processor = context.getBean(ResultsProcessor.class);
        String answearsPath = "src/main/resources/Answers.txt";
        String studentsPath = "src/main/resources/student.txt";

        int score = processor.CalculateScore(answearsPath, studentsPath);

        System.out.println("Итоговый балл ученика: " + score);
    }
}
