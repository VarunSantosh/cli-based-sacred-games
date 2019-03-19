package priv.vd.rpg.launcher;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import priv.vd.rpg.constants.ColourConstants;
import priv.vd.rpg.constants.LevelConstants;
import priv.vd.rpg.constants.TextConstants;
import priv.vd.rpg.context.DIContext;
import priv.vd.rpg.domain.Player;
import priv.vd.rpg.game.PlayGame;
import priv.vd.rpg.screens.*;
import priv.vd.rpg.util.LevelMapper;
import priv.vd.rpg.util.SaveAndResumeUtil;


public class GameLauncher {

    private static final Logger LOG = LogManager.getLogger(GameLauncher.class);
    private static ScreenFactory screenFactory = DIContext.getBean(ScreenFactory.class);
    private static PlayGame game = DIContext.getBean(PlayGame.class);

    public static void launchGame() {

        LOG.debug("launched Game......");
        Player player = new Player();

        screenFactory.getScreen(TextConstants.GAME_INTRO_SCREEN.toString()).showMessage();
        String firstChoice = screenFactory.getScreen(TextConstants.GAME_INTRO_SCREEN.toString()).showChoices();

        //Adding Empty Lines
        System.out.println();
        System.out.println();
        System.out.println();

        switch (firstChoice) {
            case "S":
                LOG.debug("User decided to start a new game.");
                PlayerRegistrationScreen prScreen = (PlayerRegistrationScreen) screenFactory.getScreen(TextConstants.PLAYER_REGISTRATION_SCREEN.toString());
                prScreen.showMessage();
                player = prScreen.registerPlayer();
                LOG.debug("created player: " + player.getName());
                break;
            case "R":
                LOG.debug("User decided to resume his previous game.");
                ExistingPlayerScreen epScreen = (ExistingPlayerScreen) screenFactory.getScreen(TextConstants.EXISTING_PLAYER_SCREEN.toString());
                epScreen.showMessage();
                String playerName = epScreen.showChoices();
                if ("".equals(playerName) || playerName == null) {
                    LOG.debug("User decided to not continue with the game.");
                    ExitScreen eScreen = (ExitScreen) screenFactory.getScreen(TextConstants.EXIT_SCREEN.toString());
                    eScreen.showMessage();
                } else {
                    player = SaveAndResumeUtil.getSavedPlayerByName(playerName);
                    LOG.debug("existing player: " + player.getName() + "loaded and can resume his game.");
                }
                break;
            case "Q":
                LOG.debug("User decided to not continue with the game.");
                ExitScreen eScreen = (ExitScreen) screenFactory.getScreen(TextConstants.EXIT_SCREEN.toString());
                eScreen.showMessage();
                break;
            default:
                break;
        }

        //Adding Empty Lines
        System.out.println();
        System.out.println();
        System.out.println();

        PlayerCurrentStatusScreen pcsScreen = (PlayerCurrentStatusScreen) screenFactory.getScreen(TextConstants.PLAYER_STATUS.toString());
        pcsScreen.showMessage(player);
        String choice = screenFactory.getScreen(TextConstants.PLAYER_STATUS.toString()).showChoices();

        switch (choice) {
            case "S":
                startTheGame(player);
                break;
            case "Q":
                if (player.getLevel() == null) {
                    player.setLevel(LevelMapper.mapToLevelOne());
                }
                SaveAndResumeUtil.savePlayerState(player);
            default:
                ExitScreen eScreen = (ExitScreen) screenFactory.getScreen(TextConstants.EXIT_SCREEN.toString());
                eScreen.showMessage();
                break;
        }
    }

    private static void startTheGame(Player player) {

        if (player.getLevel() == null) {
            player.setLevel(LevelMapper.mapToLevelOne());
        }

        switch (player.getLevel().getId()) {
            case 1:
                if (player.getLevel() == null) {
                    player.setLevel(LevelMapper.mapToLevelOne());
                }
                System.out.println(ColourConstants.ANSI_BLUE + "------------------------------------------------------------------------");
                System.out.println(ColourConstants.ANSI_BLUE + "\t You are on LEVEL 1");
                System.out.println(ColourConstants.ANSI_BLUE + "\t" + LevelConstants.LEVEL_ONE.getDescription());
                System.out.println(ColourConstants.ANSI_BLUE + "------------------------------------------------------------------------");
                player = game.play(player);

            case 2:
                if (player.getLevel().getId() == 1) {
                    player.setLevel(LevelMapper.mapToLevelTwo());
                    player.setCurrentHealthPoints(player.getCurrentHealthPoints() + LevelConstants.LEVEL_TWO.getLevelHealthPointsToBeAdded());
                    player.setVillainsLeft(LevelConstants.LEVEL_TWO.getVillains());
                }
                System.out.println(ColourConstants.ANSI_BLUE + "------------------------------------------------------------------------");
                System.out.println(ColourConstants.ANSI_BLUE + "\t Congratulations you have reached LEVEL 2");
                System.out.println(ColourConstants.ANSI_BLUE + "\t" + LevelConstants.LEVEL_TWO.getDescription());
                System.out.println(ColourConstants.ANSI_BLUE + "------------------------------------------------------------------------");
                player = game.play(player);

            case 3:
                if (player.getLevel().getId() == 2) {
                    player.setLevel(LevelMapper.mapToLevelThree());
                    player.setCurrentHealthPoints(player.getCurrentHealthPoints() + LevelConstants.LEVEL_THREE.getLevelHealthPointsToBeAdded());
                    player.setVillainsLeft(LevelConstants.LEVEL_THREE.getVillains());
                }
                System.out.println(ColourConstants.ANSI_BLUE + "------------------------------------------------------------------------");
                System.out.println(ColourConstants.ANSI_BLUE + "\t Congratulations you have reached LEVEL 3");
                System.out.println(ColourConstants.ANSI_BLUE + "\t" + LevelConstants.LEVEL_THREE.getDescription());
                System.out.println(ColourConstants.ANSI_BLUE + "------------------------------------------------------------------------");
                player = game.play(player);

            default:
                SaveAndResumeUtil.savePlayerState(player);
                System.out.println(ColourConstants.ANSI_BLUE.toString() + "#####################################  Congratulations you won the game  #####################################");
                ExitScreen eScreen = (ExitScreen) screenFactory.getScreen(TextConstants.EXIT_SCREEN.toString());
                eScreen.showMessage();
                break;
        }
    }
}
