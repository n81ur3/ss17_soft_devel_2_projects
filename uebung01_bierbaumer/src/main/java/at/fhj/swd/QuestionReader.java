package at.fhj.swd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * @author Helmut Bierbaumer
 *         Created on 2017/05/20.
 */
public class QuestionReader {

    public ArrayList<Question> readQuestions(String location) {

        try {
            //BufferedReader in = new BufferedReader(new FileReader("/mnt/data/Personal_data/OneDrive/Documents/Privat/FH/SS2017/SoftDevel2/soft_devel_2_projects/01_exercise_bierbaumer/src/main/resources/sample_quiz.csv"));
            BufferedReader in = new BufferedReader(new FileReader(location));
            //BufferedReader in = new BufferedReader(new FileReader(new File(getClass().getClassLoader().getResource("sample_quiz.csv").getPath())));
            String s;
            StringBuilder sb = new StringBuilder();
            while ((s = in.readLine()) != null) {
                sb.append(s);
                sb.append("\n");
            }
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
