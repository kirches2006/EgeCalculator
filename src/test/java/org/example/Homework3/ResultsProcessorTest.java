package org.example.Homework3;

import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
class ResultsProcessorTest {

    @Test
    void calculateScore() throws IOException {
        String studentFilePath = "src/test/java/org/example/Homework3/studentFile";
        String answearsFilePath = "src/test/java/org/example/Homework3/answearsFile";

       File studentFile = new File(studentFilePath);
       File answearsFile = new File(answearsFilePath);

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(studentFile))){
            writer.write("1 - A\n");
            writer.write("2 - B\n");
            writer.write("3 - D\n");
            writer.write("4 - A\n");
            writer.write("5 - B\n");
            writer.write("6 - D\n");
            writer.write("7 - A\n");
            writer.write("8 - B\n");
            writer.write("9 - D\n");
        }

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(answearsFile))){
            writer.write("1 - A\n");
            writer.write("2 - B\n");
            writer.write("3 - C\n");
            writer.write("4 - A\n");
            writer.write("5 - B\n");
            writer.write("6 - C\n");
            writer.write("7 - A\n");
            writer.write("8 - B\n");
            writer.write("9 - C\n");
        }

        AnswearsReader AnswearsReader = new AnswearsReader();
        ResultsProcessor res = new ResultsProcessor(AnswearsReader);
        res.setGroupPoints(1, 2, 3);

        int score = res.CalculateScore(answearsFilePath, studentFilePath);

        assertEquals(9, score);

    }
}