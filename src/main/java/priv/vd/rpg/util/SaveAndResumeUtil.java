package priv.vd.rpg.util;

import priv.vd.rpg.domain.Player;
import priv.vd.rpg.exception.InternalResourceException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class SaveAndResumeUtil {

    private static Map<String, Player> savedPlayers = new HashMap<>();
    private static final String path = "./src/main/resources/saved_players/";
    private static final String file_ext = ".ser";

    /**
     * This block of code loads all the existing saved player state to the savedPlayers map when this class is loaded.
     */
    static {
        File file = new File(path);
        File[] files = file.listFiles((dir, n) -> (true));
        loadExistingPlayers(files);
    }

    /**
     * This methods iterates over the File array, deserializes them and then puts them into map.
     * @param files Array of File
     */
    private static void loadExistingPlayers(File[] files) {
        if (!(files == null) && !(files.length == 0)) {
            for (File file : files) {
                Player p = deserializeFiles(file);
                savedPlayers.put(p.getName().toUpperCase(), p);
            }
        }
    }

    /**
     * This methods takes in a File object and the deserializes it to a player object.
     * @param file
     * @return It returns a player object
     */
    private static Player deserializeFiles(File file) {
        Player player = null;
        try (
                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ) {
            player = (Player) objectInputStream.readObject();
        } catch (Throwable t) {
            throw new InternalResourceException(t);
        }

        return player;
    }

    /**
     * This method get the player object by searching savedPlayers map on the basis of player name.
     * @param name
     * @return
     */
    public static Player getSavedPlayerByName(String name) {
        return savedPlayers.get(name);
    }

    /**
     * This method saves the state of a player by serializing it.
     * @param player
     */
    public static void savePlayerState(Player player) {
        String filePath = path +
                player.getName().toUpperCase() +
                file_ext;
        try (
                FileOutputStream fileOutputStream = new FileOutputStream(filePath);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        ) {
            objectOutputStream.writeObject(player);
            objectOutputStream.flush();
        } catch (Throwable t) {
            throw new InternalResourceException(t);
        }
    }

    /**
     *
     * @param name
     * @return
     */
    public static boolean isPlayerNameValid(String name) {
        return savedPlayers.get(name.toUpperCase()) != null;
    }
}
