package at.fhj.swd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * @author Helmut Bierbaumer
 *         Created on 2017/05/20.
 */
public class QuestionReader {
    private Validator validator;

    public QuestionReader(Validator validator) {
        this.validator = validator;
    }

    public ArrayList<Question> readQuestions(String location) {
        ArrayList<Question> questions = new ArrayList<>();

        try {
            //BufferedReader in = new BufferedReader(new FileReader("/mnt/data/Personal_data/OneDrive/Documents/Privat/FH/SS2017/SoftDevel2/soft_devel_2_projects/01_exercise_bierbaumer/src/main/resources/sample_quiz.csv"));
            BufferedReader in = new BufferedReader(new FileReader(location));
            //BufferedReader in = new BufferedReader(new FileReader(new File(getClass().getClassLoader().getResource("sample_quiz.csv").getPath())));
            String line;
            while ((line = in.readLine()) != null) {
                if (validator.isValid(line)) {
                    questions.add(getQuestionFromLine(line));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return questions;
    }



    private Question getQuestionFromLine(String line) {
        String[] parts = line.split(";");
        String question = parts[0];
        String answerText = parts[1];
        String[] answers = answerText.split("/");
        int correctAnswer = Integer.parseInt(parts[2]);

        return new Question(question, answers, correctAnswer);
    }
}
