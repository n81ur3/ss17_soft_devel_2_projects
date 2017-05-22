package at.fhj.swd;

import java.util.ArrayList;

/**
 * @author Helmut Bierbaumer
 *         Created on 2017/05/20.
 */
public class Main {

    public static void main(String[] args) {
        HtmlQuestionWriter writer = new HtmlQuestionWriter();
        Validator validator = new QuizQuestionValidator();
        QuestionReader reader = new QuestionReader(validator);

        if (args.length != 2) {
            printUsageInfo();
            System.exit(0);
        }

        ArrayList<Question> questions = reader.readQuestions(args[0]);

        if (questions != null) {
            writer.writeQuestion(args[1], questions);
        } else {
            System.out.println("No questions available");
        }
    }

    private static void printUsageInfo() {
        System.out.println("You must provide two command line arguments");
        System.out.println("First argument: location of the csv file from which to import questions");
        System.out.println("Second argument: output-path to write the html file containing the formated questions");
        System.out.println("Usage:");
        System.out.println("java at.fhj.swd.Main <file_to_read> <file_to_write>");
    }
}
