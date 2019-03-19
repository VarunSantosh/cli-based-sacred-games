package priv.vd.rpg.exception;

public class InternalResourceException extends RuntimeException {
    private static String MSG = "All hell broke loose! Shutting everything down...";

    public InternalResourceException() {
        super(MSG);
    }

    public InternalResourceException(Throwable cause) {
        super(MSG, cause);
    }
}