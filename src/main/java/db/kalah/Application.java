package db.kalah;


import db.kalah.game.KalahPlay;

public class Application {

    public static void main(String[] args) {
        Integer boardSize = 6;
        Integer defaultPitSize = 6;

        KalahPlay kalahPlay = new KalahPlay(boardSize, defaultPitSize);
        kalahPlay.playGame();
    }

}
