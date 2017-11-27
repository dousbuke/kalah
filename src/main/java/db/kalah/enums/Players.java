package db.kalah.enums;


public enum Players {

    FIRST_PLAYER("First Player"),
    SECOND_PLAYER("Second Player");

    private String playerName;

    Players(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }
}
