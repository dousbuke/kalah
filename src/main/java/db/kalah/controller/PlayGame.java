package db.kalah.controller;

import db.kalah.enums.GameStatus;
import db.kalah.enums.Players;
import db.kalah.engine.GameEngine;
import db.kalah.model.PlayerBoards;
import db.kalah.util.Paint;

import static db.kalah.config.GameSetUp.initGame;
import static db.kalah.util.PitSelection.playerPitSelection;
import static db.kalah.status.GameStatusCheck.checkGameStatusByPitNumber;
import static db.kalah.status.GameTurnCheck.checkGameTurn;
import static db.kalah.util.Messages.printTurnMessage;


public class PlayGame {

    private PlayerBoards playerBoards;
    private GameStatus gameStatus;
    private Players currentPlayer;
    private Paint board;
    private GameEngine firstPlayerGameEngine;
    private GameEngine secondPlayerGameEngine;

    public PlayGame(Integer pitCount, Integer defaultPitSize) {
        this.playerBoards = new PlayerBoards(pitCount);
        this.currentPlayer = Players.FIRST_PLAYER;
        this.board = new Paint(playerBoards.getFirstPlayerBoard(), playerBoards.getSecondPlayerBoard());
        this.gameStatus = initGame();
        this.firstPlayerGameEngine = new GameEngine(defaultPitSize);
        this.secondPlayerGameEngine = new GameEngine(defaultPitSize);
    }

    public void playGame() {
        board.paint();

        do {
            playTurn();

            board.paint();

            gameStatus = checkGameStatusByPitNumber(playerBoards);
            if (currentPlayer == Players.FIRST_PLAYER) {
                currentPlayer = checkGameTurn(currentPlayer, firstPlayerGameEngine.isLastStone);
            } else {
                currentPlayer = checkGameTurn(currentPlayer, secondPlayerGameEngine.isLastStone);
            }

        } while (gameStatus == GameStatus.PLAYING);
    }

    private void playTurn() {
        if (currentPlayer == Players.FIRST_PLAYER) {
            printTurnMessage(currentPlayer);

            Integer selectedPit = playerPitSelection(playerBoards.getFirstPlayerBoard());

            firstPlayerGameEngine.movement(selectedPit, playerBoards, currentPlayer);
        } else if (currentPlayer == Players.SECOND_PLAYER) {
            printTurnMessage(currentPlayer);

            Integer pit = playerPitSelection(playerBoards.getSecondPlayerBoard());

            secondPlayerGameEngine.movement(pit, playerBoards, currentPlayer);
        }
    }

}
