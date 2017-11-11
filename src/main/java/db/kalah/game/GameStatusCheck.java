package db.kalah.game;


import db.kalah.dto.request.GameStatusCheckRequest;
import db.kalah.dto.response.GameStatusCheckResponse;
import db.kalah.enums.GameStatus;
import db.kalah.model.Board;
import db.kalah.util.Utils;

public class GameStatusCheck {

    public static GameStatusCheckResponse gameStatusCheck(GameStatusCheckRequest request) {
        GameStatus status = checkForGameStatus(request.getFirstPlayerBoard(), request.getSecondPlayerBoard());

        return GameStatusCheckResponse.builder().status(status).build();
    }

    public static GameStatus checkForGameStatus(Board firstPlayerBoard, Board secondPlayerBoard) {
        int firstPlayerBoardSum, secondPlayerBoardSum;

        firstPlayerBoardSum = Utils.sum(firstPlayerBoard.getPits());
        secondPlayerBoardSum = Utils.sum(secondPlayerBoard.getPits());

        if (firstPlayerBoardSum == 0 && secondPlayerBoardSum == 0) {
            if (firstPlayerBoard.getMainPit().getPit() > secondPlayerBoard.getMainPit().getPit()) {
                return GameStatus.FIRST_PLAYER_WIN;
            } else if (firstPlayerBoard.getMainPit().getPit() < secondPlayerBoard.getMainPit().getPit()) {
                return GameStatus.SECOND_PLAYER_WIN;
            } else if (firstPlayerBoard.getMainPit().getPit() == secondPlayerBoard.getMainPit().getPit()) {
                return GameStatus.DRAW;
            }
        }

        return GameStatus.PLAYING;
    }
}
