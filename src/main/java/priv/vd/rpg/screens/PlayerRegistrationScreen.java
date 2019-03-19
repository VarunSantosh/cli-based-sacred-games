package priv.vd.rpg.screens;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import priv.vd.rpg.constants.Avatar;
import priv.vd.rpg.constants.ColourConstants;
import priv.vd.rpg.constants.LevelConstants;
import priv.vd.rpg.domain.Player;
import priv.vd.rpg.util.ConsoleUtil;
import priv.vd.rpg.util.InternalIOUtil;
import priv.vd.rpg.util.SaveAndResumeUtil;
import priv.vd.rpg.util.ValidationUtil;

public class PlayerRegistrationScreen implements Screen {

    private static final Logger LOG = LogManager.getLogger(GameIntroScreen.class);

    @Override
    public void showMessage() {

        LOG.debug("Loading the player registration message...");
        System.out.println(ColourConstants.ANSI_BLUE.toString() + "--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(ColourConstants.ANSI_BLUE.toString() + "                                                     NEW PLAYER CREATION                                                              ");
        System.out.println(ColourConstants.ANSI_BLUE.toString() + "--------------------------------------------------------------------------------------------------------------------------------------");
    }

    @Override
    public String showChoices() {
        return null;
    }
    
    public static Player registerPlayer() {

        LOG.debug("Creating player....");
        System.out.print(ColourConstants.ANSI_YELLOW.toString() + "Enter player name : ");
        String name = ConsoleUtil.readUserInput();
        boolean isPlayerNameValid = SaveAndResumeUtil.isPlayerNameValid(name);
        while (isPlayerNameValid) {
            System.out.println(ColourConstants.ANSI_RED.toString() + "The player name you entered already exists.");
            System.out.print(ColourConstants.ANSI_YELLOW.toString() + "Enter player name : ");
            name = ConsoleUtil.readUserInput();
            isPlayerNameValid = SaveAndResumeUtil.isPlayerNameValid(name);
        }

        System.out.println();
        System.out.println(ColourConstants.ANSI_YELLOW.toString() + "Select an Avatar");
        System.out.println(ColourConstants.ANSI_YELLOW.toString() + "For Dabangg enter D/d");
        System.out.println(ColourConstants.ANSI_YELLOW.toString() + "For Simba enter S/s");
        System.out.println(ColourConstants.ANSI_YELLOW.toString() + "For Singham enter G/g");

        //Reading choice
        String[] possibleChoices = new String[]{"D", "d", "S", "s", "G", "g"};
        System.out.print(ColourConstants.ANSI_YELLOW.toString() + "Enter your choice: ");
        String choice = ConsoleUtil.readUserInput();
        boolean validChoice = ValidationUtil.validateChoices(choice, possibleChoices);
        while(!validChoice) {
            System.out.println(ColourConstants.ANSI_RED.toString() + "Not a valid choice");
            System.out.print(ColourConstants.ANSI_YELLOW.toString() + "Enter your choice: ");
            choice = ConsoleUtil.readUserInput();
            validChoice = ValidationUtil.validateChoices(choice, possibleChoices);
        }

        Avatar av;
        switch (choice) {
            case "D":
                av = Avatar.DABANG;
                break;
            case "S":
                av = Avatar.SIMBA;
                break;
            case "G":
                av = Avatar.SINGHAM;
                break;
            default:
                System.out.println(ColourConstants.ANSI_RED.toString() + "Since you didn't select an avatar or you have entered a wrong choice. Your default avatar is Dabangg");
                av = Avatar.DABANG;
                break;
        }
        System.out.println();

        Player player = new Player();
        player.setName(name);
        player.setAvatar(av);
        player.setCurrentHealthPoints(LevelConstants.LEVEL_ONE.getLevelHealthPointsToBeAdded());
        player.setVillainsLeft(LevelConstants.LEVEL_ONE.getVillains());
        player.setLevel(null);

        System.out.println(ColourConstants.ANSI_GREEN.toString() + "Congratulations player profile \"" + player.getName() + "\" created. Please note the player name for future references.");
        LOG.debug("Loading the game intro message...");
        String asciiArt = InternalIOUtil.readAsciiArtAsString(player.getAvatar().toString());
        System.out.println();
        System.out.println(ColourConstants.ANSI_GREEN.toString() + "Your Avatar is........");
        System.out.println();
        System.out.println(ColourConstants.ANSI_GREEN.toString() + asciiArt);
        System.out.println();
        System.out.println(ColourConstants.ANSI_GREEN.toString() + "Show no mercy to the villains. Go for the kill!!!!!");

        LOG.debug("Player with name " + player.getName() + " created.");

        return player;
    }
}
