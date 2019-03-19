package priv.vd.rpg.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import priv.vd.rpg.context.DIContext;

import java.util.Scanner;

public class ConsoleUtil {

    private static final Logger LOG = LogManager.getLogger(ConsoleUtil.class);
    private static final Scanner sc = DIContext.getBean(Scanner.class);

    public static String readUserInput() {
        String choice = sc.nextLine();
        return choice.toUpperCase().trim();
    }
}
