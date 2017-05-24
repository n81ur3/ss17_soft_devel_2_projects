package at.fhj.swd;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Helmut Bierbaumer
 *         Created on 2017/05/20.
 */
public class Main {

    public static void main(String[] args) {
        HtmlOutputFormatter formatter = new HtmlOutputFormatter();
        HtmlQuestionWriter writer = new HtmlQuestionWriter(formatter);
        Validator validator = new QuizQuestionValidator();
        QuestionReader reader = new QuestionReader(validator);

        if (args.length != 2) {
            printUsageInfo();
            System.exit(0);
        }

        ArrayList<Question> questions = reader.readQuestions(args[0]);

        if (questions != null && questions.size() > 0) {
            setStyle(formatter);
            writer.writeQuestion(args[1], questions);
            if (promptForOutput()) {
                HtmlViewer.displayHtml("file", args[1]);
            }
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

    /**
     * Sets title and CSS style information for the html output file
     * @param formatter
     */
    private static void setStyle(HtmlOutputFormatter formatter) {
        formatter.setTitle("My Sample Quiz");
        formatter.addStyle("body", "font-family: arial");
        formatter.addStyle("h2", "color: #D1E7FF", "background-color: #204A87",
                "text-align: center", "padding: 10px");
        formatter.addStyle("h3", "color: #204A87", "margin-left: 20px");
        formatter.addStyle("div.question", "background-color: #BFD1E4",
                "padding: 10px", "margin: 20px", "border: 2px solid black");
        formatter.addStyle("li.correct", "color: blue");
    }

    /**
     * Gives user the opportunity to display the already created html file
     * @return
     */
    private static boolean promptForOutput() {
        System.out.println("HTML file created successfully\nWant to see the result? [y/n]: ");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        return choice.toLowerCase().startsWith("y");
    }
}
