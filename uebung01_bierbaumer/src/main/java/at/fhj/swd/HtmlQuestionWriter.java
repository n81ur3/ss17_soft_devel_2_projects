package at.fhj.swd;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * A class to create html files
 * @author Helmut Bierbaumer
 *         Created on 2017/05/20.
 */
public class HtmlQuestionWriter {
    private final HtmlOutputFormatter formatter;

    public HtmlQuestionWriter(HtmlOutputFormatter formatter) {
        this.formatter = formatter;
    }

    /**
     * Writes the given array of Question elements into a html file
     * @param destination the storage location for the output file
     * @param questions the array to include in the html file
     */
    public void writeQuestion(String destination, ArrayList<Question> questions) {
        try (PrintWriter writer = new PrintWriter(destination)) {
            writer.write(formatter.getFormattedString(questions));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
