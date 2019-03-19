package priv.vd.rpg.domain;

import java.io.Serializable;

/**
 * Villain class.
 */
public class Villain implements Serializable {

    private static final long serialVersionUID = 1934681035957329122L;

    private int id;
    private String name;
    private int health;

    /**
     * Villain constructor
     * @param id             - a unique identifier for the villian
     * @param name           - name for the villian
     * @param health         - maximu  health of the villian
     */
    public Villain(int id, String name, int health) {
        this.id = id;
        this.name = name;
        this.health = health;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
