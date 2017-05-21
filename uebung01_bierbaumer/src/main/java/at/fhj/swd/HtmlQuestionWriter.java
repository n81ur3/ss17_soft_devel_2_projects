package at.fhj.swd;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @author Helmut Bierbaumer
 *         Created on 2017/05/20.
 */
public class HtmlQuestionWriter {
    private final static String HEADER = "<!DOCTYPE html>\n" +
            "<html xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"de\" xml:lang=\"de\">\n" +
            "<head>\n" +
            "\t<meta charset=\"UTF-8\" />\n" +
            "\t<meta name=\"viewport\" content=\"width=device-width\" />\n" +
            "\t<title>SWD Quiz</title>\n" +
            "\t<meta name=\"author\" content=\"Helmut Bierbaumer\" />\n" +
            "</head>\n" +
            "<body>";
    private final static String FOOTER = "</body>\n</html>";

    public void writeQuestion(String location, ArrayList<Question> questions) {
        try {
            PrintWriter writer = new PrintWriter(location);
            writer.write(HEADER);
            writer.write("<h2>Fragen:</h2>");
            for (Question q : questions) {
                writer.write("<h3>" + q.getQuestion() + "</h3>");
                writer.write("<ol>");
                for (String answer : q.getAnswers()) {
                    writer.write("<li>" + answer + "</li>");
                }
                writer.write("</ol>");
            }
            writer.write(FOOTER);
            writer.flush();
            writer.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
