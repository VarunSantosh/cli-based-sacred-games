package priv.vd.rpg.util;

import priv.vd.rpg.exception.InternalResourceException;

import java.io.BufferedReader;
import java.io.FileReader;

public class InternalIOUtil {

    private InternalIOUtil() {
    }

    private static final String ASCII_ART_FOLDER_PATH = "./src/main/resources/ascii_art";
    private static final String DIR_SEPARATOR = "/";
    private static final String NEXT_LINE_CHARACTER = "\n";


    public static String readAsciiArtAsString(String fileName) {
        StringBuilder asciiArtString = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(absolutePathInsideArchive(fileName)))) {
            String line;
            while ((line = in.readLine()) != null) {
                asciiArtString.append(line);
                asciiArtString.append(NEXT_LINE_CHARACTER);
            }
        } catch (Throwable t) {
            throw new InternalResourceException(t);
        }

        return asciiArtString.toString();
    }

    private static String absolutePathInsideArchive(String filename) {
        return InternalIOUtil.ASCII_ART_FOLDER_PATH + DIR_SEPARATOR + filename;
    }
}
