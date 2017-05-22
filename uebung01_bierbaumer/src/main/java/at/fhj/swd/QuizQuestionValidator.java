package at.fhj.swd;

/**
 * @author Helmut Bierbaumer
 *         Created on 2017/05/22.
 */
public class QuizQuestionValidator implements Validator {

    @Override
    public boolean isValid(String stringToCheck) {

        if (stringToCheck.startsWith("#") || stringToCheck.isEmpty()) {
            return false;
        }

        String answerText;
        String correctAnswer;

        String[] parts = stringToCheck.split(";");
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
}
