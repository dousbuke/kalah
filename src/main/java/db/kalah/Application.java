package db.kalah;


import db.kalah.game.PlayGame;

public class Application {

    public static void main(String[] args) {
        Integer pitCount = 6;
        Integer defaultPitSize = 6;

        PlayGame playGame = new PlayGame(pitCount, defaultPitSize);
        playGame.playGame();
    }

}
