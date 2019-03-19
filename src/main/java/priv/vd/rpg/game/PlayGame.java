package priv.vd.rpg.game;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import priv.vd.rpg.constants.ColourConstants;
import priv.vd.rpg.constants.TextConstants;
import priv.vd.rpg.context.DIContext;
import priv.vd.rpg.domain.Player;
import priv.vd.rpg.domain.Villain;
import priv.vd.rpg.screens.ExitScreen;
import priv.vd.rpg.screens.ScreenFactory;
import priv.vd.rpg.util.ConsoleUtil;
import priv.vd.rpg.util.SaveAndResumeUtil;
import priv.vd.rpg.util.ValidationUtil;

import java.util.Random;

public class PlayGame {

    private static final Logger LOG = LogManager.getLogger(PlayGame.class);
    private static ScreenFactory screenFactory = DIContext.getBean(ScreenFactory.class);

    public Player play(Player player) {

        Random rand = new Random();
        boolean running = true;
        System.out.println();
        System.out.println();
        System.out.println(ColourConstants.ANSI_BLUE + "------------------------------------------------------------------------");
        System.out.println(ColourConstants.ANSI_BLUE + "\t You are on Battle Ground");
        System.out.println(ColourConstants.ANSI_BLUE + "------------------------------------------------------------------------");
        System.out.println();
        System.out.println();

        GAME:
        while (running) {
            System.out.println(ColourConstants.ANSI_BLUE + "---------------------------LET'S FIGHT----------------------------------");
            System.out.println(ColourConstants.ANSI_BLUE + "\t######" + player.getVillainsLeft()[0].getName() + " encountered!######\n");

            int combatCount = 0;
            while (player.getVillainsLeft()[0].getHealth() > 0) {
                ++combatCount;
                System.out.println();
                System.out.println(ColourConstants.ANSI_BLUE + "*****************   Combat No: " + combatCount + "   *****************");
                System.out.println(ColourConstants.ANSI_BLUE + "\t Your Health      " + player.getCurrentHealthPoints());
                System.out.println(ColourConstants.ANSI_BLUE + "\t Villains Health  " + player.getVillainsLeft()[0].getHealth());
                System.out.println(ColourConstants.ANSI_BLUE + "What would you like to do?");
                System.out.println(ColourConstants.ANSI_BLUE + "\t1. Combat");
                System.out.println(ColourConstants.ANSI_BLUE + "\t2. Drink Health potion");

                String choice = readChoices();

                if ("1".equals(choice)) {

                    //damage done to the enemy
                    int damageDealt = rand.nextInt(player.getLevel().getPlayerAttackDamage());
                    // damage enemy did to the player
                    int damageTaken = rand.nextInt(player.getLevel().getEnemyAttackDamage());

                    //reduce enemy health
                    player.getVillainsLeft()[0].setHealth(player.getVillainsLeft()[0].getHealth() - damageDealt);
                    //reduce player health
                    player.setCurrentHealthPoints(player.getCurrentHealthPoints() - damageTaken);

                    System.out.println(ColourConstants.ANSI_GREEN + "\t Your Strike the villain for " + damageDealt + " health points");
                    System.out.println(ColourConstants.ANSI_RED + "\t Your received " + damageTaken + " health points damage in retaliation");

                    if (player.getCurrentHealthPoints() < 1) {
                        System.out.println(ColourConstants.ANSI_RED + "\t Your received a lot of damage and you are too weak to continue..");
                        System.out.println(ColourConstants.ANSI_BLUE + "------------------------------------------------------------------------");
                        System.out.println(ColourConstants.ANSI_BLUE + "\t You lost in LEVEL " + player.getLevel().getId() + " fighting with " + player.getVillainsLeft()[0].getName());
                        System.out.println(ColourConstants.ANSI_BLUE + "------------------------------------------------------------------------");
                        SaveAndResumeUtil.savePlayerState(player);
                        ExitScreen eScreen = (ExitScreen) screenFactory.getScreen(TextConstants.EXIT_SCREEN.toString());
                        eScreen.showMessage();
                    }

                } else {

                    //check if the player has any health potion left
                    if (player.getLevel().getAvailableNoOfHealthPotions() > 0) {
                        //Add the health potion points to the health of the player
                        player.setCurrentHealthPoints(player.getLevel().getHealthPotionPoints() + player.getCurrentHealthPoints());
                        //remove the available no of health potions
                        player.getLevel().setAvailableNoOfHealthPotions(player.getLevel().getAvailableNoOfHealthPotions() - 1);
                        System.out.println(ColourConstants.ANSI_BLUE + "\t Your Health:      " + player.getCurrentHealthPoints());
                        System.out.println(ColourConstants.ANSI_BLUE + "\t Number of Health potion left with you: " + player.getLevel().getAvailableNoOfHealthPotions());

                    } else {
                        System.out.println(ColourConstants.ANSI_RED + "\t Your health potions are exhausted. You have no more health potion left with you.");
                    }
                }
            }

            System.out.println(ColourConstants.ANSI_GREEN + "\t Wooo hooo! you have killed " + player.getVillainsLeft()[0].getName());

            //Removing the Villain whom player has defeated
            Villain[] newVillainArr = new Villain[(player.getVillainsLeft().length - 1)];
            for (int i = 1; i < player.getVillainsLeft().length; i++) {
                newVillainArr[i - 1] = player.getVillainsLeft()[i];
            }
            player.setVillainsLeft(newVillainArr);

            if (player.getVillainsLeft().length > 0) {
                System.out.println();
                System.out.println(ColourConstants.ANSI_BLUE + "-----------------------------------------------------------------------");
                System.out.println(ColourConstants.ANSI_BLUE + "\t Your Health      " + player.getCurrentHealthPoints());
                System.out.println(ColourConstants.ANSI_BLUE + "What would you like to do?");
                System.out.println(ColourConstants.ANSI_BLUE + "\t1. Fight Another Villain");
                System.out.println(ColourConstants.ANSI_BLUE + "\t2. Pause the game and quit");

                String choice = readChoices();

                if ("1".equals(choice)) {
                    continue GAME;

                } else {
                    SaveAndResumeUtil.savePlayerState(player);
                    ExitScreen eScreen = (ExitScreen) screenFactory.getScreen(TextConstants.EXIT_SCREEN.toString());
                    eScreen.showMessage();
                }
            } else {
                running = false;
            }
        }
        System.out.println();
        System.out.println(ColourConstants.ANSI_BLUE + "------------------------------------------------------------------------");
        System.out.println(ColourConstants.ANSI_BLUE + "\t Congratulations you have successfully completed LEVEL " + player.getLevel().getId());
        System.out.println(ColourConstants.ANSI_BLUE + "------------------------------------------------------------------------");

        System.out.println(ColourConstants.ANSI_BLUE + "-----------------------------------------------------------------------");
        System.out.println(ColourConstants.ANSI_BLUE + "\t Your Health:     " + player.getCurrentHealthPoints());
        System.out.println(ColourConstants.ANSI_BLUE + "What would you like to do?");
        System.out.println(ColourConstants.ANSI_BLUE + "\t1. Go to the next level");
        System.out.println(ColourConstants.ANSI_BLUE + "\t2. Pause the game and resume later.");

        String choice = readChoices();

        if ("1".equals(choice)) {
            return player;
        } else {
            SaveAndResumeUtil.savePlayerState(player);
            ExitScreen eScreen = (ExitScreen) screenFactory.getScreen(TextConstants.EXIT_SCREEN.toString());
            eScreen.showMessage();
            return null;
        }
    }

    private String readChoices() {
        String[] possibleChoices = new String[]{"1", "2"};
        System.out.print(ColourConstants.ANSI_BLUE.toString() + "Enter your choice: ");
        String choice = ConsoleUtil.readUserInput();
        boolean validChoice = ValidationUtil.validateChoices(choice, possibleChoices);
        while (!validChoice) {
            System.out.println(ColourConstants.ANSI_RED.toString() + "Not a valid choice");
            System.out.print(ColourConstants.ANSI_BLUE.toString() + "Enter your choice: ");
            choice = ConsoleUtil.readUserInput();
            validChoice = ValidationUtil.validateChoices(choice, possibleChoices);
        }
        return choice;
    }
}
