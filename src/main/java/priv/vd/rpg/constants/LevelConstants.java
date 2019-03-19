package priv.vd.rpg.constants;

import priv.vd.rpg.domain.Villain;

/*
 * This enum class defines the number of levels that our game has.
 * Every level has some properties set.
 * If in future we want to create more levels in thsi game, we can create another constant level with appropriate values.
 */
public enum LevelConstants {

    LEVEL_ONE(1, TextConstants.LEVEL_ONE_NAME.toString(), TextConstants.LEVEL_ONE_DESCRIPTION.toString(), new Villain[]{new Villain(1, "DURYODHAN", 30), new Villain(2, "DUSHALA", 40), new Villain(3, "SHAKUNI", 50)}, 10, 5, 100, 3, 20),
    LEVEL_TWO(2, TextConstants.LEVEL_TWO_NAME.toString(), TextConstants.LEVEL_TWO_DESCRIPTION.toString(), new Villain[]{new Villain(4, "ATAPI", 50), new Villain(5, "VATAPI", 75)}, 15, 10, 100, 2, 40),
    LEVEL_THREE(3, TextConstants.LEVEL_THREE_NAME.toString(), TextConstants.LEVEL_THREE_DESCRIPTION.toString(), new Villain[]{new Villain(6, "GAITONDE", 100)}, 20, 25, 100, 1, 50);

    private int id;
    private String name;
    private String desc;
    private Villain[] villains;
    private int playerAttackDamage;
    private int enemyAttackDamage;
    private int levelHealthPointsToBeAdded;
    private int availableNoOfHealthPotions;
    private int healthPotionPoints;

    /**
     * @param id                         - Unique id of the Level
     * @param name                       - Name of the Level
     * @param desc                       - Description about the level
     * @param villains                   - Villians that the user has to fight in this level
     * @param playerAttackDamage         - Points to be deducted from villians health when the player hits him.
     * @param enemyAttackDamage          - Points to be deducted from player's health when the villian hits him.
     * @param levelHealthPointsToBeAdded - Health points that's added to the player's health when he raeches this level.
     * @param availableNoOfHealthPotions - Number of health potions that the player gets in this level.
     * @param healthPotionPoints         - Health points that are added to players health when he uses a health potion.
     */
    LevelConstants(int id, String name, String desc, Villain[] villains, int playerAttackDamage, int enemyAttackDamage, int levelHealthPointsToBeAdded, int availableNoOfHealthPotions, int healthPotionPoints) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.villains = villains;
        this.playerAttackDamage = playerAttackDamage;
        this.enemyAttackDamage = enemyAttackDamage;
        this.levelHealthPointsToBeAdded = levelHealthPointsToBeAdded;
        this.availableNoOfHealthPotions = availableNoOfHealthPotions;
        this.healthPotionPoints = healthPotionPoints;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.desc;
    }

    public Villain[] getVillains() {
        return this.villains;
    }

    public int getPlayerAttackDamage() {
        return this.playerAttackDamage;
    }

    public int getEnemyAttackDamage() {
        return this.enemyAttackDamage;
    }

    public int getLevelHealthPointsToBeAdded() {
        return this.levelHealthPointsToBeAdded;
    }

    public int getAvailableNoOfHealthPotions() {
        return this.availableNoOfHealthPotions;
    }

    public int getHealthPotionPoints() {
        return this.healthPotionPoints;
    }
}
