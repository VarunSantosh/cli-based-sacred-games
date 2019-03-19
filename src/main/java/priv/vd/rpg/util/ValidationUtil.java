package priv.vd.rpg.util;

public class ValidationUtil {

    public static boolean validateChoices(String choice, String[] possibleChoices) {
        for (String possibleChoice : possibleChoices) {
            if (possibleChoice.equalsIgnoreCase(choice)) {
                return true;
            }
        }
        return false;
    }
}
