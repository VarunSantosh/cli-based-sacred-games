package priv.vd.rpg.util;

import priv.vd.rpg.constants.LevelConstants;
import priv.vd.rpg.domain.Level;

public class LevelMapper {

    public static Level mapToLevelOne() {
        Level l = new Level();
        l.setId(LevelConstants.LEVEL_ONE.getId());
        l.setAvailableNoOfHealthPotions(LevelConstants.LEVEL_ONE.getAvailableNoOfHealthPotions());
        l.setEnemyAttackDamage(LevelConstants.LEVEL_ONE.getEnemyAttackDamage());
        l.setLevelHealthPointsToBeAdded(LevelConstants.LEVEL_ONE.getLevelHealthPointsToBeAdded());
        l.setHealthPotionPoints(LevelConstants.LEVEL_ONE.getHealthPotionPoints());
        l.setPlayerAttackDamage(LevelConstants.LEVEL_ONE.getPlayerAttackDamage());

        return l;
    }

    public static Level mapToLevelTwo() {
        Level l = new Level();
        l.setId(LevelConstants.LEVEL_TWO.getId());
        l.setAvailableNoOfHealthPotions(LevelConstants.LEVEL_TWO.getAvailableNoOfHealthPotions());
        l.setEnemyAttackDamage(LevelConstants.LEVEL_TWO.getEnemyAttackDamage());
        l.setLevelHealthPointsToBeAdded(LevelConstants.LEVEL_TWO.getLevelHealthPointsToBeAdded());
        l.setHealthPotionPoints(LevelConstants.LEVEL_TWO.getHealthPotionPoints());
        l.setPlayerAttackDamage(LevelConstants.LEVEL_TWO.getPlayerAttackDamage());

        return l;
    }

    public static Level mapToLevelThree() {
        Level l = new Level();
        l.setId(LevelConstants.LEVEL_THREE.getId());
        l.setAvailableNoOfHealthPotions(LevelConstants.LEVEL_THREE.getAvailableNoOfHealthPotions());
        l.setEnemyAttackDamage(LevelConstants.LEVEL_THREE.getEnemyAttackDamage());
        l.setLevelHealthPointsToBeAdded(LevelConstants.LEVEL_THREE.getLevelHealthPointsToBeAdded());
        l.setHealthPotionPoints(LevelConstants.LEVEL_THREE.getHealthPotionPoints());
        l.setPlayerAttackDamage(LevelConstants.LEVEL_THREE.getPlayerAttackDamage());

        return l;
    }
}
