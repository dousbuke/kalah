package db.kalah.exceptions;


import lombok.NonNull;

public class GameException extends RuntimeException {

    private static final long serialVersionUID = -5792262414757953866L;

    @NonNull
    private final GameError gameError;

    private Throwable throwable;

    public GameException(String message, GameError gameError) {
        super(gameError.getErrorMessage());
        this.gameError = gameError;
    }

    public GameException(GameError gameError) {
        super(gameError.getErrorMessage());
        this.gameError = gameError;
    }

    public GameException(GameError gameError, Throwable throwable) {
        super(gameError.getErrorMessage());
        this.gameError = gameError;
        this.throwable = throwable;
    }
}
