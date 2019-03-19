package priv.vd.rpg.domain;

import java.io.Serializable;

public class Level implements Serializable {

    private static final long serialVersionUID = -7904572565349386825L;

    private int id;
    private int playerAttackDamage;
    private int enemyAttackDamage;
    private int levelHealthPointsToBeAdded;
    private int availableNoOfHealthPotions;
    private int healthPotionPoints;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlayerAttackDamage() {
        return playerAttackDamage;
    }

    public void setPlayerAttackDamage(int playerAttackDamage) {
        this.playerAttackDamage = playerAttackDamage;
    }

    public int getEnemyAttackDamage() {
        return enemyAttackDamage;
    }

    public void setEnemyAttackDamage(int enemyAttackDamage) {
        this.enemyAttackDamage = enemyAttackDamage;
    }

    public int getLevelHealthPointsToBeAdded() {
        return levelHealthPointsToBeAdded;
    }

    public void setLevelHealthPointsToBeAdded(int levelHealthPointsToBeAdded) {
        this.levelHealthPointsToBeAdded = levelHealthPointsToBeAdded;
    }

    public int getAvailableNoOfHealthPotions() {
        return availableNoOfHealthPotions;
    }

    public void setAvailableNoOfHealthPotions(int availableNoOfHealthPotions) {
        this.availableNoOfHealthPotions = availableNoOfHealthPotions;
    }

    public int getHealthPotionPoints() {
        return healthPotionPoints;
    }

    public void setHealthPotionPoints(int healthPotionPoints) {
        this.healthPotionPoints = healthPotionPoints;
    }
}
