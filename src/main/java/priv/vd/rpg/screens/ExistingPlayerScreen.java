package priv.vd.rpg.screens;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import priv.vd.rpg.constants.ColourConstants;
import priv.vd.rpg.util.ConsoleUtil;
import priv.vd.rpg.util.SaveAndResumeUtil;

public class ExistingPlayerScreen implements Screen {

    private static final Logger LOG = LogManager.getLogger(ExistingPlayerScreen.class);

    @Override
    public void showMessage() {
        LOG.debug("Loading the existing player messages...");
        System.out.println(ColourConstants.ANSI_GREEN.toString() + "--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(ColourConstants.ANSI_GREEN.toString() + "                                                             WELCOME BACK                                                             ");
        System.out.println(ColourConstants.ANSI_GREEN.toString() + "--------------------------------------------------------------------------------------------------------------------------------------");
    }

    @Override
    public String showChoices() {
        LOG.debug("Loading the existing player choices...");
        System.out.println(ColourConstants.ANSI_YELLOW.toString() + "You will have to enter your name i.e., the player name with which you were playing");
        System.out.println(ColourConstants.ANSI_YELLOW.toString() + "It will give you five attempts to recall your player name. If you after five attempts do not recall the name \n" + " then the game would exit and you will have to restart the game.");
        System.out.println();

        int count = 5;
        System.out.print("Enter the player name you last played with: ");
        String name = ConsoleUtil.readUserInput();
        boolean isPlayerNameValid = SaveAndResumeUtil.isPlayerNameValid(name);
        while (!(isPlayerNameValid) && count > 0) {
            System.out.print("Enter the player name you last played with: ");
            name = ConsoleUtil.readUserInput();
            isPlayerNameValid = SaveAndResumeUtil.isPlayerNameValid(name);
            count--;
        }
        return name;
    }
}
