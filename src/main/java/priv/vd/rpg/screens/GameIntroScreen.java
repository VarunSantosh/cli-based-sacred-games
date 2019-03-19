package priv.vd.rpg.screens;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import priv.vd.rpg.constants.ColourConstants;
import priv.vd.rpg.constants.TextConstants;
import priv.vd.rpg.util.ConsoleUtil;
import priv.vd.rpg.util.InternalIOUtil;
import priv.vd.rpg.util.ValidationUtil;

public class GameIntroScreen implements Screen{

    private static final Logger LOG = LogManager.getLogger(GameIntroScreen.class);
    private static final String fileName = "sacredGames.txt";

    @Override
    public void showMessage() {
        LOG.debug("Loading the game intro message...");
        String asciiArt = InternalIOUtil.readAsciiArtAsString(fileName);
        System.out.println(ColourConstants.ANSI_RED.toString() + asciiArt);

        System.out.println(ColourConstants.ANSI_BLUE.toString() + "----------------------------------------------------------------STORY-----------------------------------------------------------------");
        System.out.println(ColourConstants.ANSI_BLUE.toString() + TextConstants.GAME_DESCRIPTION.toString());
        System.out.println(ColourConstants.ANSI_BLUE.toString() + "--------------------------------------------------------------------------------------------------------------------------------------");

        System.out.println(ColourConstants.ANSI_BLUE.toString() + "-------------------------------------------------------------HOW TO PLAY--------------------------------------------------------------");
        System.out.println(ColourConstants.ANSI_BLUE.toString() + TextConstants.HOW_TO_PLAY.toString());
        System.out.println(ColourConstants.ANSI_BLUE.toString() + "--------------------------------------------------------------------------------------------------------------------------------------");
    }

    @Override
    public String showChoices() {

        LOG.debug("Loading the intro choices...");
        //Showing choices
        System.out.println(ColourConstants.ANSI_GREEN.toString() + "----------------------------------------------------");
        System.out.println("Please choose one of the options.");
        System.out.println(ColourConstants.ANSI_GREEN.toString() + "----------------------------------------------------");
        System.out.println("Type S/s to start a new game.");
        System.out.println("Type R/r to resume game.");
        System.out.println("Type Q/q to quit.");
        System.out.println(ColourConstants.ANSI_GREEN.toString() + "----------------------------------------------------");

        //Reading choice
        String[] possibleChoices = new String[]{"S", "s", "R", "r", "Q", "q"};
        System.out.print(ColourConstants.ANSI_GREEN.toString() + "Enter your choice: ");
        String choice = ConsoleUtil.readUserInput();
        boolean validChoice = ValidationUtil.validateChoices(choice, possibleChoices);
        while(!validChoice) {
            System.out.println(ColourConstants.ANSI_RED.toString() + "Not a valid choice");
            System.out.print(ColourConstants.ANSI_GREEN.toString() + "Enter your choice: ");
            choice = ConsoleUtil.readUserInput();
            validChoice = ValidationUtil.validateChoices(choice, possibleChoices);
        }
        return choice;
    }
}
