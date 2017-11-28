package db.kalah.game;

import db.kalah.enums.Players;
import db.kalah.model.Board;
import db.kalah.model.PlayerBoards;
import db.kalah.util.Utils;


public class PlayerMovement {

    private Integer pitCount;
    public boolean isLastStone;

    public PlayerMovement(Integer pitCount) {
        this.pitCount = pitCount;
        this.isLastStone = false;
    }

    public void movement(int selectedPit, PlayerBoards playerBoards, Players currentPlayer) {
        int pitCount;
        int mainPit;
        int updatedPitCount;
        int currentPit;

        Board homePlayer;
        Board opponent;

        if (currentPlayer.equals(Players.FIRST_PLAYER)) {
            homePlayer = playerBoards.getFirstPlayerBoard();
            opponent = playerBoards.getSecondPlayerBoard();
        } else {
            homePlayer = playerBoards.getSecondPlayerBoard();
            opponent = playerBoards.getFirstPlayerBoard();
        }

        pitCount = homePlayer.getPits().get(selectedPit - 1).getPit();

        homePlayer.getPits().get(selectedPit - 1).setPit(0);
        mainPit = homePlayer.getMainPit().getPit();

        for (int i = 0; i < pitCount; i++) {

            if (selectedPit == this.pitCount) {
                mainPit += 1;
                homePlayer.getMainPit().setPit(mainPit);
                isLastStone = (i == pitCount - 1);
            } else if (selectedPit < this.pitCount) {
                updatedPitCount = homePlayer.getPits().get(selectedPit).getPit();
                updatedPitCount += 1;
                homePlayer.getPits().get(selectedPit).setPit(updatedPitCount);

                // last sown lands on empty pit then collect home and opponent
                if (i == pitCount - 1 && updatedPitCount == 1) {
                    mainPit = mainPit + homePlayer.getPits().get(selectedPit).getPit() + opponent.getPits().get(Utils.opponentPitMap(selectedPit) - 1).getPit();
                    homePlayer.getMainPit().setPit(mainPit);
                    homePlayer.getPits().get(selectedPit).setPit(0);
                    opponent.getPits().get(Utils.opponentPitMap(selectedPit) - 1).setPit(0);
                }
            } else if (selectedPit > this.pitCount) {
                currentPit = selectedPit - 7;

                if (currentPit > this.pitCount - 1) {
                    selectedPit = -1;
                    i = i - 1;
                } else {
                    updatedPitCount = opponent.getPits().get(currentPit).getPit();
                    updatedPitCount += 1;
                    opponent.getPits().get(currentPit).setPit(updatedPitCount);
                }
            }

            selectedPit++;
        }

        if (homePlayer.isBoardEmpty()) {
            opponent.getMainPit().setPit(opponent.getMainPit().getPit() + Utils.sum(opponent.pits));
            Utils.clearPits(opponent.pits);
        }

    }


}

