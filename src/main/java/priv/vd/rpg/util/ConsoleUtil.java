package priv.vd.rpg.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import priv.vd.rpg.context.DIContext;

import java.util.Scanner;

public class ConsoleUtil {

    private static final Logger LOG = LogManager.getLogger(ConsoleUtil.class);
    private static final Scanner sc = DIContext.getBean(Scanner.class);

    /**
     * TODO
     * Find a better way to clear the console
     */
    public static void clearConsole() {
        for(int i = 0; i <= 100; i++){
            System.out.println();
        }
    }

    public static String readUserInput() {
        String choice = sc.nextLine();
        return choice.toUpperCase().trim();
    }
}
