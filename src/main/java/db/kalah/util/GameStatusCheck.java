package db.kalah.util;


import db.kalah.enums.GameStatus;
import db.kalah.model.PlayerBoards;

public class GameStatusCheck {

    public static GameStatus checkGameStatusByPitNumber(PlayerBoards playerBoards) {
        int firstPlayerBoardSum, secondPlayerBoardSum;

        firstPlayerBoardSum = Utils.sum(playerBoards.getFirstPlayerBoard().getPits());
        secondPlayerBoardSum = Utils.sum(playerBoards.getSecondPlayerBoard().getPits());

        if (firstPlayerBoardSum == 0 && secondPlayerBoardSum == 0) {
            if (playerBoards.getFirstPlayerBoard().getMainPit().getPit() > playerBoards.getSecondPlayerBoard().getMainPit().getPit()) {
                return GameStatus.FIRST_PLAYER_WIN;
            } else if (playerBoards.getFirstPlayerBoard().getMainPit().getPit() < playerBoards.getSecondPlayerBoard().getMainPit().getPit()) {
                return GameStatus.SECOND_PLAYER_WIN;
            } else if (playerBoards.getFirstPlayerBoard().getMainPit().getPit() == playerBoards.getSecondPlayerBoard().getMainPit().getPit()) {
                return GameStatus.DRAW;
            }
        }

        return GameStatus.PLAYING;
    }

    public static void checkGameStatusByWinner(GameStatus gameStatus) {
        if (gameStatus == GameStatus.FIRST_PLAYER_WIN) {
            System.out.println("First Player won!");
        } else if (gameStatus == GameStatus.SECOND_PLAYER_WIN) {
            System.out.println("Second Player won!");
        } else if (gameStatus == GameStatus.DRAW) {
            System.out.println("It's a draw");
        }
    }
}
