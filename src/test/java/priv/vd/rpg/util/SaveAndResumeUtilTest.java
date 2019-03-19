package priv.vd.rpg.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import priv.vd.rpg.constants.Avatar;
import priv.vd.rpg.constants.LevelConstants;
import priv.vd.rpg.domain.Level;
import priv.vd.rpg.domain.Player;

public class SaveAndResumeUtilTest {

    private Player player = new Player();
    private Level level = new Level();

    @Before
    public void setup() {
        player.setName("Test");
        player.setCurrentHealthPoints(LevelConstants.LEVEL_ONE.getLevelHealthPointsToBeAdded());
        player.setAvatar(Avatar.DABANG);
        level = LevelMapper.mapToLevelOne();
        player.setLevel(level);
        player.setVillainsLeft(LevelConstants.LEVEL_ONE.getVillains());
    }

    @Test
    public void testSaveAndResumeUtil(){
        SaveAndResumeUtil.savePlayerState(player);

        Assert.assertFalse(SaveAndResumeUtil.isPlayerNameValid("Data"));

        Player p2 = SaveAndResumeUtil.getSavedPlayerByName("TEST");
        Assert.assertEquals("Test", p2.getName());
    }
}
