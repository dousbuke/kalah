package db.kalah.game;

import db.kalah.enums.Players;
import db.kalah.model.Board;
import db.kalah.model.PlayerBoards;
import db.kalah.util.Utils;


public class PlayerMovement {

    private Integer pitCount;

    public PlayerMovement(Integer pitCount) {
        this.pitCount = pitCount;
    }

    public boolean movement(int selectedPit, PlayerBoards playerBoards, Players currentPlayer) {
        int pitCount;
        int mainPit;
        int updatedPitCount;
        int currentPit;
        boolean isLastStone = false;
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
                isLastStone = (i == pitCount - 1) ? true : false;
            } else if (selectedPit < this.pitCount) {
                updatedPitCount = homePlayer.getPits().get(selectedPit).getPit();
                updatedPitCount += 1;
                homePlayer.getPits().get(selectedPit).setPit(updatedPitCount);

                // last sown lands on empty pit then collect home and opponent
                if (i == pitCount - 1 && updatedPitCount == 1) {
                    mainPit = mainPit + homePlayer.getPits().get(selectedPit).getPit() + opponent.getPits().get(opponentPitMap(selectedPit) - 1).getPit();
                    homePlayer.getMainPit().setPit(mainPit);
                    homePlayer.getPits().get(selectedPit).setPit(0);
                    opponent.getPits().get(opponentPitMap(selectedPit) - 1).setPit(0);
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

        return isLastStone;
    }

    //Todo make util
    private static int opponentPitMap(int pit) {
        int opposite = 0;
        switch (pit) {
            case 1:
                opposite = 5;
                break;
            case 2:
                opposite = 4;
                break;
            case 3:
                opposite = 3;
                break;
            case 4:
                opposite = 2;
                break;
            case 5:
                opposite = 1;
                break;
            case 6:
                opposite = 1;
                break;
            default:
                assert false : "invalid pit " + pit;
                break;
        }

        return opposite;
    }
}
