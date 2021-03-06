package at.fhj.swd;

/**
 * @author Helmut Bierbaumer
 *         Created on 2017/05/22.
 */
public class QuizQuestionValidator implements Validator {

    /**
     * Checks the given String if it has the correct format of a quiz question
     * @param stringToCheck the String to check for usage
     * @return true if the format is conform, false otherwise
     */
    @Override
    public boolean isValid(String stringToCheck) {

        if (stringToCheck.startsWith("#") || stringToCheck.isEmpty()) {
            return false;
        }

        String[] parts = stringToCheck.split(";");
        if (parts.length != 3) {
            return false;
        }

        for (String s : parts) {
            if (s.isEmpty()) {
                return false;
            }
        }

        if(!(checkAnswerIndex(parts[1], parts[2]))) {
            return false;
        }

        return true;
    }

    /**
     * Checks for a valid answer index. The index must be in the range 2-4
     * @param answerText a String containing the possible answers separated by a slash
     * @param correctAnswer the zero-based index of the correct answer
     * @return true if the answer index is in range 2-4 and not higher than (no. of possible answers - 1), false otherwise
     */
    private boolean checkAnswerIndex(String answerText, String correctAnswer) {

        if (!(correctAnswer.matches("[0-4]"))) {
            return false;
        }

        String[] answers = answerText.split("/");
        int correctIndex = Integer.parseInt(correctAnswer);

        if (answers.length < 2 || correctIndex > answers.length - 1) {
            return false;
        }

        return true;
    }
}
