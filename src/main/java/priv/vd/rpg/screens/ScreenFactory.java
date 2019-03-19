package priv.vd.rpg.screens;

import priv.vd.rpg.constants.TextConstants;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Using factory design pattern here.
 * In future multiple screens can be added to be used by the game.
 */
public class ScreenFactory {

    private final static Map<String, Supplier<Screen>> map = new HashMap<>();

    static {
        map.put(TextConstants.GAME_INTRO_SCREEN.toString(), GameIntroScreen::new);
        map.put(TextConstants.PLAYER_REGISTRATION_SCREEN.toString(), PlayerRegistrationScreen::new);
        map.put(TextConstants.EXISTING_PLAYER_SCREEN.toString(), ExistingPlayerScreen::new);
        map.put(TextConstants.PLAYER_STATUS.toString(), PlayerCurrentStatusScreen::new);
        map.put(TextConstants.LEVEL_INTRO_SCREEN.toString(), LevelsIntroScreen::new);
        map.put(TextConstants.EXIT_SCREEN.toString(), ExitScreen::new);
    }

    public Screen getScreen(String screenType){
        Supplier<Screen> screen = map.get(screenType.toUpperCase());
        if(screen != null) {
            return screen.get();
        }
        throw new IllegalArgumentException("No such screen " + screenType.toUpperCase());
    }
}
