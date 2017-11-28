package db.kalah.game;

import db.kalah.enums.GameStatus;
import db.kalah.enums.Players;
import db.kalah.model.PlayerBoards;
import db.kalah.util.Paint;

import static db.kalah.config.GameSetUp.initGame;
import static db.kalah.game.PlayerPitSelection.playerPitSelection;
import static db.kalah.util.GameStatusCheck.checkGameStatusByPitNumber;
import static db.kalah.util.GameTurnCheck.checkGameTurn;


public class KalahPlay {

    private PlayerBoards playerBoards;
    private GameStatus gameStatus;
    private Players currentPlayer;
    private Paint board;
    private boolean isLastStone;
    private PlayerMovement firstPlayerMovement;
    private PlayerMovement secondPlayerMovement;

    public KalahPlay(Integer pitCount, Integer defaultPitSize) {
        this.playerBoards = new PlayerBoards(pitCount);
        this.currentPlayer = Players.FIRST_PLAYER;
        this.board = new Paint(playerBoards.getFirstPlayerBoard(), playerBoards.getSecondPlayerBoard());
        this.gameStatus = initGame();
        this.isLastStone = false;
        this.firstPlayerMovement = new PlayerMovement(defaultPitSize);
        this.secondPlayerMovement = new PlayerMovement(defaultPitSize);
    }

    public void playGame() {
        board.paint();

        do {
            playTurn();

            board.paint();

            gameStatus = checkGameStatusByPitNumber(playerBoards);

            currentPlayer = checkGameTurn(currentPlayer, isLastStone);

        } while (gameStatus == GameStatus.PLAYING);
    }

    private void playTurn() {
        if (currentPlayer == Players.FIRST_PLAYER) {
            printTurnMessage(currentPlayer);

            Integer selectedPit = playerPitSelection();

            isLastStone = firstPlayerMovement.movement(selectedPit, playerBoards, currentPlayer);
        } else if (currentPlayer == Players.SECOND_PLAYER) {
            printTurnMessage(currentPlayer);

            Integer pit = playerPitSelection();

            isLastStone = secondPlayerMovement.movement(pit, playerBoards, currentPlayer);
        }
    }

    private void printTurnMessage(Players players) {
        System.out.println(players.getPlayerName() + " turn");
    }

}
