package at.fhj.swd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A class to build Question objects
 * @author Helmut Bierbaumer
 *         Created on 2017/05/20.
 */
public class QuestionReader {
    private Validator validator;

    public QuestionReader(Validator validator) {
        this.validator = validator;
    }

    /**
     * Creates an ArrayList of Question object out of a csv file
     * @param location the storage location of the csv file to read
     * @return ArrayList of Question objects or null if no valid question information could be found
     */
    public ArrayList<Question> readQuestions(String location) {
        ArrayList<Question> questions = new ArrayList<>();

        try (BufferedReader in = new BufferedReader(new FileReader(location))) {
            String line;
            while ((line = in.readLine()) != null) {
                if (validator.isValid(line)) {
                    questions.add(getQuestionFromLine(line));
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return null;
        }

        return questions;
    }

    /**
     * Converts the information in the given String into a Question object
     * @param line String containig the necessary information for Question constructor
     * @return the constructed Question object
     */
    private Question getQuestionFromLine(String line) {
        String[] parts = line.split(";");
        String question = parts[0];
        String answerText = parts[1];
        String[] answers = answerText.split("/");
        int correctAnswer = Integer.parseInt(parts[2]);

        return new Question(question, answers, correctAnswer);
    }
}
