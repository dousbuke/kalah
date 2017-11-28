package db.kalah.exceptions;


public enum GameError {

    EMPTY_PIT_CANNOT_PLAY(1018, "Empty Pit can not play");

    private Integer errorCode;

    private String errorMessage;

    GameError(Integer errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
