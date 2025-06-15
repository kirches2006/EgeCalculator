package org.example.Homework3;

import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AnswearsReaderTest {

    @Test
    void getAnswears() throws IOException {
        String testFilePath = "src/test/java/org/example/Homework3/test-answears.txt";

        try(FileWriter writer = new FileWriter(testFilePath)){
            writer.write("1 - A\n");
            writer.write("2 - B\n");
            writer.write("3 - C\n");
        }

        AnswearsReader reader = new AnswearsReader();
        Map<Integer, String> result = reader.getAnswears(testFilePath);
        assertEquals(3, result.size());
        assertEquals("A", result.get(1));
        assertEquals("B", result.get(2));
        assertEquals("C", result.get(3));
    }

}