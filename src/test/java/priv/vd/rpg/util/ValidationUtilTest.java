package priv.vd.rpg.util;

import org.junit.Assert;
import org.junit.Test;

public class ValidationUtilTest {

    @Test
    public void testValidateChoices() {

        Assert.assertTrue(ValidationUtil.validateChoices("1", new String[]{"1", "2"}));
        Assert.assertFalse(ValidationUtil.validateChoices("3", new String[]{"1", "2"}));
    }
}
