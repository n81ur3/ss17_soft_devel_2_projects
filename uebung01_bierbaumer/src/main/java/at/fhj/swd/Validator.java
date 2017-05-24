package at.fhj.swd;

/**
 * @author Helmut Bierbaumer
 *         Created on 2017/05/22.
 */
public interface Validator {

    /**
     * Validates the given String
     * @param stringToCheck the String to check for usage
     * @return true if the String is acceptable, false otherwise
     */
    boolean isValid(String stringToCheck);
}
