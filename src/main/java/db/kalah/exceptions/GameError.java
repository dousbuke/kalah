package db.kalah.exceptions;


public enum GameError {

    EMPTY_PIT_CANNOT_PLAY(1001, "Empty Pit can not play"),
    PIT_SELECTION_WRONG(1002, "Pit Selection is wrong");

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
