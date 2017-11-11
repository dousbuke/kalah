package db.kalah.config;


import db.kalah.enums.GameStatus;

public class GameSetUp {

    public static GameStatus initGame() {
        return GameStatus.PLAYING;
    }
}
