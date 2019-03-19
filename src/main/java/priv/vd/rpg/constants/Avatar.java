package priv.vd.rpg.constants;

/*
 * This enum class contains the avatars that a player can have.
 * In future we can add more avatars.
 */
public enum Avatar {

    DABANG("Dabangg.txt"),
    SIMBA("Simba.txt"),
    SINGHAM("Singham.txt");

    private String ascii_art_file_name;

    Avatar(String ascii_art_file_name) {
        this.ascii_art_file_name = ascii_art_file_name;
    }

    public String toString() {
        return this.ascii_art_file_name;
    }
}
