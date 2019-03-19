package priv.vd.rpg.screens;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import priv.vd.rpg.constants.ColourConstants;
import priv.vd.rpg.domain.Player;
import priv.vd.rpg.util.ConsoleUtil;
import priv.vd.rpg.util.InternalIOUtil;
import priv.vd.rpg.util.ValidationUtil;

public class PlayerCurrentStatusScreen implements Screen {

    private static final Logger LOG = LogManager.getLogger(PlayerCurrentStatusScreen.class);

    @Override
    public void showMessage() {
        LOG.debug("Loading the player's current status messages...");
    }


    public void showMessage(Player player){

        System.out.println(ColourConstants.ANSI_BLUE.toString() + "---------------------------------------------------------Player's Profile-------------------------------------------------------------");
        System.out.println(ColourConstants.ANSI_BLUE.toString() + "Player's Name:                " + player.getName());
        System.out.println(ColourConstants.ANSI_BLUE.toString() + "Player's Avatar:              ");
        String asciiArt = InternalIOUtil.readAsciiArtAsString(player.getAvatar().toString());
        System.out.println();
        System.out.println(ColourConstants.ANSI_BLUE.toString() + asciiArt);
        System.out.println();
        System.out.println(ColourConstants.ANSI_BLUE.toString() + "Player's current health:       " + player.getCurrentHealthPoints());
        System.out.println(ColourConstants.ANSI_BLUE.toString() + "--------------------------------------------------------------------------------------------------------------------------------------");
    }

    @Override
    public String showChoices() {
        LOG.debug("Loading the player's choices...");
        System.out.println();
        System.out.println(ColourConstants.ANSI_GREEN.toString() + "----------------------------------------------------");
        System.out.println(ColourConstants.ANSI_GREEN.toString() + "\t Please choose one of the options.");
        System.out.println(ColourConstants.ANSI_GREEN.toString() + "----------------------------------------------------");
        System.out.println(ColourConstants.ANSI_GREEN.toString() + "Type S/s to start the new game.");
        System.out.println(ColourConstants.ANSI_RED.toString() + "Type Q/q to save and quit.");
        System.out.println(ColourConstants.ANSI_GREEN.toString() + "----------------------------------------------------");

        //Reading choice
        String[] possibleChoices = new String[]{"S", "s", "Q", "q"};
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
