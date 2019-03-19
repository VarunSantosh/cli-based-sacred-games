package priv.vd.rpg.screens;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import priv.vd.rpg.constants.ColourConstants;
import priv.vd.rpg.constants.TextConstants;

public class LevelsIntroScreen implements Screen{

    private static final Logger LOG = LogManager.getLogger(LevelsIntroScreen.class);

    @Override
    public void showMessage() {
        LOG.debug("Loading the level intro message...");

        System.out.println(ColourConstants.ANSI_GREEN.toString() + "--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(ColourConstants.ANSI_GREEN.toString() + TextConstants.GAME_DESCRIPTION.toString());
        System.out.println(ColourConstants.ANSI_GREEN.toString() + "--------------------------------------------------------------------------------------------------------------------------------------");
        }

    @Override
    public String showChoices() {
        return null;
    }
}
