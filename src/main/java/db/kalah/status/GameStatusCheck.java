package db.kalah.status;


import db.kalah.enums.GameStatus;
import db.kalah.model.PlayerBoards;
import db.kalah.util.Utils;

import static db.kalah.util.Messages.gameStatusMessage;

public class GameStatusCheck {

    public static GameStatus checkGameStatusByPitNumber(PlayerBoards playerBoards) {
        int firstPlayerBoardSum, secondPlayerBoardSum;

        firstPlayerBoardSum = Utils.sum(playerBoards.getFirstPlayerBoard().getPits());
        secondPlayerBoardSum = Utils.sum(playerBoards.getSecondPlayerBoard().getPits());

        if (firstPlayerBoardSum == 0 && secondPlayerBoardSum == 0) {
            if (playerBoards.getFirstPlayerBoard().getMainPit().getPit() > playerBoards.getSecondPlayerBoard().getMainPit().getPit()) {
                gameStatusMessage(GameStatus.FIRST_PLAYER_WIN);
                return GameStatus.FIRST_PLAYER_WIN;
            } else if (playerBoards.getFirstPlayerBoard().getMainPit().getPit() < playerBoards.getSecondPlayerBoard().getMainPit().getPit()) {
                gameStatusMessage(GameStatus.SECOND_PLAYER_WIN);
                return GameStatus.SECOND_PLAYER_WIN;
            } else if (playerBoards.getFirstPlayerBoard().getMainPit().getPit() == playerBoards.getSecondPlayerBoard().getMainPit().getPit()) {
                gameStatusMessage(GameStatus.DRAW);
                return GameStatus.DRAW;
            }
        }

        return GameStatus.PLAYING;
    }



}
