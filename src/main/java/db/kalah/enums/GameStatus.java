package db.kalah.enums;


public enum GameStatus {

    PLAYING("Playing"),
    FIRST_PLAYER_WIN("First Player"),
    SECOND_PLAYER_WIN("Second Player"),
    DRAW("Draw");

    private String gameStatusName;

    GameStatus(String gameStatusName) {
        this.gameStatusName = gameStatusName;
    }

    public String getGameStatusName() {
        return gameStatusName;
    }
}
