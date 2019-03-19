package priv.vd.rpg.context;

import priv.vd.rpg.exception.DIException;
import priv.vd.rpg.game.PlayGame;
import priv.vd.rpg.screens.ScreenFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Since using any framework was not allowed, hence created a simple DI class.
 */
public class DIContext {

    private static final Map<Class, Object> context = new HashMap<>();

    static {
        loadObjects();
    }

    private DIContext() {
    }

    private static void loadObjects() {
        Scanner sc = new Scanner(System.in);
        context.put(Scanner.class, sc);

        ScreenFactory sf = new ScreenFactory();
        context.put(ScreenFactory.class, sf);

        PlayGame game = new PlayGame();
        context.put(PlayGame.class, game);
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<T> clazz) {
        T bean;

        try {
            bean = (T) context.get(clazz);
        } catch (Throwable t) {
            throw new DIException(t);
        }

        if (null == bean) {
            throw new DIException();
        }

        return bean;
    }
}
