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
     * Checks for a valid anser index. The index must be in the range 2-4
     * @param answerText
     * @param correctAnswer
     * @return
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
