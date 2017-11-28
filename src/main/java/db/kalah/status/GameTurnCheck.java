package db.kalah.status;


import db.kalah.enums.Players;

public class GameTurnCheck {

    public static Players checkGameTurn(Players currentPlayer, boolean isLastStone) {

        if (currentPlayer == Players.FIRST_PLAYER) {
            if (isLastStone) {
                currentPlayer = Players.FIRST_PLAYER;
            } else {
                currentPlayer = Players.SECOND_PLAYER;
            }
        } else {
            if (isLastStone) {
                currentPlayer = Players.SECOND_PLAYER;
            } else {
                currentPlayer = Players.FIRST_PLAYER;
            }
        }

        return currentPlayer;
    }
}
