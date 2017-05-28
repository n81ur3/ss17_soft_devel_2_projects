package at.fhj.swd;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @author Helmut Bierbaumer
 *         Created on 2017/05/28.
 */
public class QuizQuestionValidatorTest {
    QuizQuestionValidator validator;

    @Before
    public void setup() {
        validator = new QuizQuestionValidator();
    }

    /**
     * tests the detection of invalid QuizQuestion-Line
     * @throws Exception
     */
    @Test
    public void testInvalid() throws Exception {
        ArrayList<String> malformedQuestions = new ArrayList<String>();
        malformedQuestions.add("");
        malformedQuestions.add("#");
        malformedQuestions.add(";//;2");
        malformedQuestions.add("Wie oft gewann Finnland den Song Contest?;1 mal;0");
        malformedQuestions.add("Wie viel kann Bambus pro Stunde maximal wachsen?;3mm;4cm;1");


        for (String q : malformedQuestions) {
            assertFalse(validator.isValid(q));
        }
    }

    /**
     * tests the correctness of QuizQuestion-Lines with various numbers of answers
     */
    @Test
    public void testValid() {
        ArrayList<String> validQuestions = new ArrayList<String>();
        validQuestions.add("Wie heißt der Komponist, dessen berühmteste Symphonie unvollendet blieb?;" +
                "Wolfgang Amadeus Mozart/Franz Schubert/Ludwig van Beethoven/Joseph Haydn;1");
        validQuestions.add("Wie oft gewann Finnland den Song Contest?;1 mal/2 mal/nie;0");
        validQuestions.add("Wie viel kann Bambus pro Stunde maximal wachsen?;3mm/4cm;1");

        for (String q : validQuestions) {
            assertTrue(validator.isValid(q));
        }
    }
}