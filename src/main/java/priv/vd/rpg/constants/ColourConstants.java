package priv.vd.rpg.constants;

public enum ColourConstants {

    ANSI_RED("\u001B[31m"),
    ANSI_GREEN("\u001B[32m"),
    ANSI_YELLOW("\u001B[33m"),
    ANSI_BLUE("\u001B[34m");

    private String value;

    ColourConstants(String value) {
        this.value = value;
    }

    public String toString() {
        return this.value;
    }
}
