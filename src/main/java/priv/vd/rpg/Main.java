package priv.vd.rpg;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import priv.vd.rpg.launcher.GameLauncher;

public class Main {

    private static final Logger LOG = LogManager.getLogger(Main.class);
    private static final String filePath = "./src/main/resources/music/Mysterious.mp3";

    public static void main(String[] args) {
        LOG.debug("Starting the game...");
        GameLauncher.launchGame();
    }
}
