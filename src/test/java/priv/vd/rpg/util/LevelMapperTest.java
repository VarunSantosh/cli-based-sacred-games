package priv.vd.rpg.util;

import org.junit.Assert;
import org.junit.Test;
import priv.vd.rpg.constants.LevelConstants;
import priv.vd.rpg.domain.Level;

public class LevelMapperTest {

    @Test
    public void testMapToLevelOne() {
        Level level = LevelMapper.mapToLevelOne();
        Assert.assertEquals(level.getId(), LevelConstants.LEVEL_ONE.getId());
        Assert.assertEquals(level.getAvailableNoOfHealthPotions(), LevelConstants.LEVEL_ONE.getAvailableNoOfHealthPotions());
        Assert.assertEquals(level.getEnemyAttackDamage(), LevelConstants.LEVEL_ONE.getEnemyAttackDamage());
        Assert.assertEquals(level.getPlayerAttackDamage(), LevelConstants.LEVEL_ONE.getPlayerAttackDamage());
        Assert.assertEquals(level.getHealthPotionPoints(), LevelConstants.LEVEL_ONE.getHealthPotionPoints());
        Assert.assertEquals(level.getLevelHealthPointsToBeAdded(), LevelConstants.LEVEL_ONE.getLevelHealthPointsToBeAdded());
    }

    @Test
    public void testMapToLevelTwo() {
        Level level = LevelMapper.mapToLevelTwo();
        Assert.assertEquals(level.getId(), LevelConstants.LEVEL_TWO.getId());
        Assert.assertEquals(level.getAvailableNoOfHealthPotions(), LevelConstants.LEVEL_TWO.getAvailableNoOfHealthPotions());
        Assert.assertEquals(level.getEnemyAttackDamage(), LevelConstants.LEVEL_TWO.getEnemyAttackDamage());
        Assert.assertEquals(level.getPlayerAttackDamage(), LevelConstants.LEVEL_TWO.getPlayerAttackDamage());
        Assert.assertEquals(level.getHealthPotionPoints(), LevelConstants.LEVEL_TWO.getHealthPotionPoints());
        Assert.assertEquals(level.getLevelHealthPointsToBeAdded(), LevelConstants.LEVEL_TWO.getLevelHealthPointsToBeAdded());
    }

    @Test
    public void testMapToLevelThree() {
        Level level = LevelMapper.mapToLevelThree();
        Assert.assertEquals(level.getId(), LevelConstants.LEVEL_THREE.getId());
        Assert.assertEquals(level.getAvailableNoOfHealthPotions(), LevelConstants.LEVEL_THREE.getAvailableNoOfHealthPotions());
        Assert.assertEquals(level.getEnemyAttackDamage(), LevelConstants.LEVEL_THREE.getEnemyAttackDamage());
        Assert.assertEquals(level.getPlayerAttackDamage(), LevelConstants.LEVEL_THREE.getPlayerAttackDamage());
        Assert.assertEquals(level.getHealthPotionPoints(), LevelConstants.LEVEL_THREE.getHealthPotionPoints());
        Assert.assertEquals(level.getLevelHealthPointsToBeAdded(), LevelConstants.LEVEL_THREE.getLevelHealthPointsToBeAdded());
    }
}
