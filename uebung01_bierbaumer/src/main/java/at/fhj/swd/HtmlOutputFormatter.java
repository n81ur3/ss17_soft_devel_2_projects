package at.fhj.swd;

import java.util.List;

/**
 * A class to created valid html formats
 * @author Helmut Bierbaumer
 *         Created on 2017/05/22.
 */
public class HtmlOutputFormatter {
    private String title;
    private String header = "<!DOCTYPE html>\n" +
            "<html xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"de\" xml:lang=\"de\">\n" +
            "<head>\n" +
            "\t<meta charset=\"UTF-8\" />\n" +
            "\t<meta name=\"viewport\" content=\"width=device-width\" />\n" +
            "\t<title>SWD Quiz</title>\n" +
            "\t<meta name=\"author\" content=\"Helmut Bierbaumer\" />\n" +
            "\t<style>";
    private String style = "";
    private final String bodyBegin = "\t</style>\n</head>\n<body>";
    private final String footer = "</body>\n</html>";

    /**
     * Formats the given list of questions into an appropriate output format
     * @param questions Question objects to include in the formatted output
     * @return the formatted string
     */
    public String getFormattedString(List<Question> questions) {
        StringBuilder sb = new StringBuilder();

        sb.append(header);
        sb.append(style);
        sb.append(bodyBegin);
        sb.append("<h2>" + title + "</h2>");
        sb.append("<h3>Fragen:</h3>");

        for (Question q : questions) {
            sb.append("<div class=\"question\">");
            sb.append("<h4>" + q.getQuestion() + "</h4>");
            sb.append("<ol>");
            String[] answers = q.getAnswers();
            for (int i = 0; i < answers.length; i++) {
                if (q.isCorrect(i + 1)) {
                    sb.append("<li class=\"correct\"><strong>" + answers[i] + "</strong></li>");
                } else {
                    sb.append("<li>" + answers[i] + "</li>");
                }
            }
            sb.append("</ol>");
            sb.append("</div>");
        }

        sb.append(footer);

        return sb.toString();
    }

    /**
     * Sets the headline for the html page
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Includes additional CSS style information into the html file.
     * Terminating the individual rules with a semicolon is not necessary
     * @param cssSelector a valid css selector
     * @param cssRules a set of CSS rules
     */
    public void addStyle(String cssSelector, String... cssRules) {
        style += cssSelector + " { ";
        for (String rule : cssRules) {
            style += rule + "; ";
        }
        style += "}\n";
    }
}
