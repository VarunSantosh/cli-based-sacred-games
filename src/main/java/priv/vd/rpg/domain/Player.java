package priv.vd.rpg.domain;

import priv.vd.rpg.constants.Avatar;

import java.io.Serializable;

/**
 * Player class.
 */
public class Player implements Serializable {

    private static final long serialVersionUID = 6003582274447621001L;

    private String name;
    private Avatar avatar;
    private Level level;
    private Integer currentHealthPoints;
    private Villain[] villainsLeft;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    public Level getLevel() { return level; }

    public void setLevel(Level level) { this.level = level; }

    public Integer getCurrentHealthPoints() {
        return currentHealthPoints;
    }

    public void setCurrentHealthPoints(Integer healthPoints) {
        this.currentHealthPoints = healthPoints;
    }

    public Villain[] getVillainsLeft() {
        return villainsLeft;
    }

    public void setVillainsLeft(Villain[] enemiesLeft) {
        this.villainsLeft = enemiesLeft;
    }
}
