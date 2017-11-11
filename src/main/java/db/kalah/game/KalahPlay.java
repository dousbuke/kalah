package db.kalah.game;

import db.kalah.config.GameSetUp;
import db.kalah.enums.GameStatus;
import db.kalah.enums.Players;
import db.kalah.model.Board;


public class KalahPlay {

    private static Integer BOARD = 6;

    public Board firstPlayerBoard;
    public Board secondPlayerBoard;
    public GameStatus gameStatus;
    public Players currentPlayer;


    public KalahPlay() {
        firstPlayerBoard = new Board(BOARD);
        secondPlayerBoard = new Board(BOARD);

        currentPlayer = Players.FIRST_PLAYER;
        gameStatus = GameSetUp.initGame();
        boolean isLastStone = false;

        Paint.paint(firstPlayerBoard, secondPlayerBoard);

        do {
            if (currentPlayer == Players.FIRST_PLAYER) {
                System.out.println("First Player turn");
                isLastStone = PlayerPitSelection.playerPitSelection(firstPlayerBoard, secondPlayerBoard);
            } else if (currentPlayer == Players.SECOND_PLAYER) {
                System.out.println("Second Player turn");
                isLastStone = PlayerPitSelection.playerPitSelection(secondPlayerBoard, firstPlayerBoard);
            }

            Paint.paint(firstPlayerBoard, secondPlayerBoard);

            gameStatus = GameStatusCheck.checkForGameStatus(firstPlayerBoard, secondPlayerBoard);

            if (gameStatus == GameStatus.FIRST_PLAYER_WIN) {
                System.out.println("First Player won!");
            } else if (gameStatus == GameStatus.SECOND_PLAYER_WIN) {
                System.out.println("Second Player won!");
            } else if (gameStatus == GameStatus.DRAW) {
                System.out.println("It's a draw");
            }

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

        } while (gameStatus == GameStatus.PLAYING);

    }
}
