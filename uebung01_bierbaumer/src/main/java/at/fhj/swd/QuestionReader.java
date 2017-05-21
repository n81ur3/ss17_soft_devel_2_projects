package at.fhj.swd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * @author Helmut Bierbaumer
 *         Created on 2017/05/20.
 */
public class QuestionReader {

    public ArrayList<Question> readQuestions(String location) {
        ArrayList<Question> questions = new ArrayList<>();

        try {
            //BufferedReader in = new BufferedReader(new FileReader("/mnt/data/Personal_data/OneDrive/Documents/Privat/FH/SS2017/SoftDevel2/soft_devel_2_projects/01_exercise_bierbaumer/src/main/resources/sample_quiz.csv"));
            BufferedReader in = new BufferedReader(new FileReader(location));
            //BufferedReader in = new BufferedReader(new FileReader(new File(getClass().getClassLoader().getResource("sample_quiz.csv").getPath())));
            String line;
            while ((line = in.readLine()) != null) {
                if (!(line.startsWith("#")) && !(line.isEmpty()) && isValidLine(line)) {
                    questions.add(getQuestionFromLine(line));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return questions;
    }

    private boolean isValidLine(String line) {
       String answerText;
       String correctAnswer;

       String[] parts = line.split(";");
       if (parts.length != 3) {
           return false;
       }

       for (String s : parts) {
           if (s.isEmpty()) {
               return false;
           }
       }

       answerText = parts[1];
       correctAnswer = parts[2];

       if(!(checkAnswerIndex(answerText, correctAnswer))) {
          return false;
       }

        return true;
    }

    private boolean checkAnswerIndex(String answerText, String correctAnswer) {

        if (!(correctAnswer.matches("[0-4]"))) {
            return false;
        }

        String[] answers = answerText.split("/");
        int correctIndex = Integer.parseInt(correctAnswer);

        if (answers.length < 2 || correctIndex > answers.length) {
            return false;
        }

        return true;
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
