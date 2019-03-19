package priv.vd.rpg.screens;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import priv.vd.rpg.constants.ColourConstants;
import priv.vd.rpg.constants.TextConstants;
import priv.vd.rpg.util.InternalIOUtil;

public class ExitScreen implements Screen {

    private static final Logger LOG = LogManager.getLogger(GameIntroScreen.class);
    private static final String fileName = "sacredGames.txt";

    @Override
    public void showMessage() {
        LOG.debug("Loading the exit messages...");
        System.out.println(ColourConstants.ANSI_GREEN.toString() + TextConstants.GAME_EXIT_MESSAGE.toString());

        System.out.println();
        String asciiArt = InternalIOUtil.readAsciiArtAsString(fileName);
        System.out.println(ColourConstants.ANSI_RED.toString() + asciiArt);

        System.out.println();
        System.out.println(ColourConstants.ANSI_GREEN.toString() + "-------------------------------------------------------------  CREDITS  --------------------------------------------------------------");
        System.out.println(ColourConstants.ANSI_GREEN.toString() + TextConstants.CREDITS.toString());
        System.out.println(ColourConstants.ANSI_GREEN.toString() + "--------------------------------------------------------------------------------------------------------------------------------------");

        System.out.println();
        System.out.println(ColourConstants.ANSI_BLUE.toString() + "                                                 Hope you enjoyed the game. Come back soon!                                           ");

        //Exit application
        System.exit(0);
    }

    @Override
    public String showChoices() {
        return null;
    }
}
