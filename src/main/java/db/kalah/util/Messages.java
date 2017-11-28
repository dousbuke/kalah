package db.kalah.util;


import db.kalah.enums.GameStatus;
import db.kalah.enums.Players;

public class Messages {

    public static void printTurnMessage(Players players) {
        System.out.println(players.getPlayerName() + " turn");
    }

    public static void gameStatusMessage(GameStatus gameStatus) {
        if (GameStatus.DRAW.equals(gameStatus)) {
            System.out.println("It's a draw");
        } else {
            System.out.println(gameStatus.getGameStatusName() + " won!");
        }
    }
}
