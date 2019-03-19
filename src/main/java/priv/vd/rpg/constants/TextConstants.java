package priv.vd.rpg.constants;

/**
 * These are the text constants like the messages that we display in the console.
 */
public enum TextConstants {
    // Game description
    GAME_DESCRIPTION("\t This game is about saving residents in the city of Mumbai, India from the goons, who have come from different parts of India. \n"
            + "\t These goons are infamous for taking lives of innocent people of the city of Mumbai to gain power and they want to control Mumbai. \n"
            + "\t They have created havoc in the city of Mumbai and the people of the city are living in terror for years now. \n"
            + "\t You are commissioned as a senior police officer in Mumbai. \n"
            + "\t One fine night when you were alone in the police station, you get a tip off from your local sources that \n"
            + "\t all the major goons of the city are going to attend a party in a very famous night club in Mumbai. \n"
            + "\t You decide to go their and fight them on your own."),

    // Game instructions
    HOW_TO_PLAY("\t This game has three levels. \n"
            + "\t In every level you will fight with enemies i.e., goons. \n"
            + "\t You will start the game with an initial health level.  \n"
            + "\t Everytime you do a combat, your health level decreases. \n"
            + "\t In every level you will also options to drink health potions to improve your health \n"
            + "\t Number of health potions that you can drink depends on the level in which you are playing. \n"
            + "\t With every level your combat skills become better. \n"
            + "\t Finish all the levels to win the game. "),

    //Exit Page status
    ME("Varun Damani"),
    GAME_EXIT_MESSAGE("#########################################   Thank you for playing   #########################################"),
    CREDITS("\t Producer : " + ME + "\n"
            + "\t Story    : " + ME + "\n"
            + "\t Concept  : " + ME ),

    //LevelConstants Names
    LEVEL_ONE_NAME("KAURAVA TIKDI"),
    LEVEL_TWO_NAME("ATAPI VATAPI"),
    LEVEL_THREE_NAME("GAITONDE"),

    // Level Constants descriptions
    LEVEL_ONE_DESCRIPTION("This level is named after a trio of Kaurava, Duryodhan, Dursanan and Dushala, who are known to kill the police by having a fist fight."),
    LEVEL_TWO_DESCRIPTION("The level is named after two demon brothers, Atapi and Vatapi, who trap and kill the police in a unique way."),
    LEVEL_THREE_DESCRIPTION("This level is named after the most dangerous villian of the game, who shows no mercy to police officers. He is very powerful and very difficult to defeat."),

    //Screens
    GAME_INTRO_SCREEN("GIS"),
    LEVEL_INTRO_SCREEN("LIS"),
    EXISTING_PLAYER_SCREEN("EPS"),
    PLAYER_STATUS("PS"),
    PLAYER_REGISTRATION_SCREEN("PRS"),
    EXIT_SCREEN("ES");

    private String value;

    TextConstants(String value) {
        this.value = value;
    }

    public String toString() {
        return this.value;
    }
}
