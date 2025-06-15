package org.example.Homework3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Path;
import java.util.Map;


@Service
public class ResultsProcessor {

    @Value("${group1.points}")
    private int group1Points;

    @Value("${group2.points}")
    private int group2Points;

    @Value("${group3.points}")
    private int group3Points;

    private final AnswearsReader answearsReader;

    public ResultsProcessor(AnswearsReader answearsReader) {
        this.answearsReader = answearsReader;
    }


    public int CalculateScore(String answearstFilePath, String studentsFilePath){


        Map<Integer, String> correctMap = answearsReader.getAnswears(answearstFilePath);
        Map<Integer, String> studentMap = answearsReader.getAnswears(studentsFilePath);

        int total = 0;
        for(int i = 1; i<=10; i++){
            String correctAns = correctMap.get(i);
            String studentAns = studentMap.get(i);

            if (correctAns != null && correctAns.equals(studentAns)){
                if (i <=4){total += group1Points;}
                else if (i<=8){total += group2Points;}
                else{total += group3Points;}
            }
        }
        return total;
    }

}
