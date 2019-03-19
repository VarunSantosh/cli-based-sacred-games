package priv.vd.rpg.util;

import org.junit.Assert;
import org.junit.Test;
import priv.vd.rpg.exception.InternalResourceException;

import java.io.BufferedReader;
import java.io.FileReader;

public class InternalIOUtilTest {

    @Test
    public void testReadAsciiArtAsString() {

        String actualOutput = InternalIOUtil.readAsciiArtAsString("Dabangg.txt");
        StringBuilder expectedOutput = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader("./src/main/resources/ascii_art/Dabangg.txt"))) {
            String line;
            while ((line = in.readLine()) != null) {
                expectedOutput.append(line);
                expectedOutput.append("\n");
            }
        } catch (Exception ex) {
            throw new InternalResourceException(ex);
        }

        Assert.assertEquals(expectedOutput.toString(), actualOutput);
    }

    @Test(expected = InternalResourceException.class)
    public void testReadAsciiArtAsStringToThrowExp() throws Exception{

        InternalIOUtil.readAsciiArtAsString("Daba.txt");

    }
}
