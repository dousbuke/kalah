package db.kalah.game;

import db.kalah.model.Board;
import db.kalah.util.Utils;


public class PlayerMovement {

    public static boolean movement(int pit, Board homePlayer, Board opponent) {
        int pitCount;
        int mainPit;
        int updatedPitCount;
        int currentPit;
        boolean isLastStone = false;

        pitCount = homePlayer.getPits().get(pit - 1).getPit();
        homePlayer.getPits().get(pit - 1).setPit(0);
        mainPit = homePlayer.getMainPit().getPit();

        for (int i = 0; i < pitCount; i++) {

            if (pit == 6) {
                mainPit += 1;
                homePlayer.getMainPit().setPit(mainPit);
                isLastStone = (i == pitCount - 1) ? true : false;
            } else if (pit < 6) {
                updatedPitCount = homePlayer.getPits().get(pit).getPit();
                updatedPitCount += 1;
                homePlayer.getPits().get(pit).setPit(updatedPitCount);

                // last sown lands on empty pit then collect home and opponent
                if (i == pitCount - 1 && updatedPitCount == 1) {
                    mainPit = mainPit + homePlayer.getPits().get(pit).getPit() + opponent.getPits().get(opponentPit(pit) - 1).getPit();
                    homePlayer.getMainPit().setPit(mainPit);
                    homePlayer.getPits().get(pit).setPit(0);
                    opponent.getPits().get(opponentPit(pit) - 1).setPit(0);
                }
            } else if (pit > 6) {
                currentPit = pit - 7;

                if (currentPit > 5) {
                    pit = -1;
                    i = i - 1;
                } else {
                    updatedPitCount = opponent.getPits().get(currentPit).getPit();
                    updatedPitCount += 1;
                    opponent.getPits().get(currentPit).setPit(updatedPitCount);
                }
            }

            pit++;
        }

        if (isBoardEmpty(homePlayer)) {
            opponent.getMainPit().setPit(opponent.getMainPit().getPit() + Utils.sum(opponent.pits));
            Utils.clearPits(opponent.pits);
        }

        return isLastStone;
    }

    private static boolean isBoardEmpty(Board homePlayer) {
        return Utils.sum(homePlayer.pits) == 0;
    }

    private static int opponentPit(int pit) {
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
