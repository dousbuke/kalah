package db.kalah.game;

import db.kalah.dto.request.SelectPitRequest;
import db.kalah.dto.response.SelectPitResponse;
import db.kalah.model.Board;
import db.kalah.util.AssertUtils;
import db.kalah.util.Utils;


public class PlayerMovement {

    public static SelectPitResponse selectPitResponse(SelectPitRequest request) throws Exception {
        AssertUtils.assertTrue(PlayerPitSelection.validatePit(request.getPit()));

        return movement(request.getPit(), request.getPlayer(), request.getOpponent());
    }

    private static SelectPitResponse movement(int pit, Board homePlayer, Board opponentPlayer) {
        int pitCount;
        int mainPit;
        int updatedPitCount;
        int currentPit;
        boolean lastStone = false;

        pitCount = homePlayer.getPits().get(pit - 1).getPit();
        homePlayer.getPits().get(pit - 1).setPit(0);
        mainPit = homePlayer.getMainPit().getPit();

        for (int i = 0; i < pitCount; i++) {

            if (pit == 6) {
                mainPit += 1;
                homePlayer.getMainPit().setPit(mainPit);
                lastStone = (i == pitCount - 1) ? true : false;
            } else if (pit < 6) {
                updatedPitCount = homePlayer.getPits().get(pit).getPit();
                updatedPitCount += 1;
                homePlayer.getPits().get(pit).setPit(updatedPitCount);

                // last sown lands on empty pit then collect home and opponent
                if (i == pitCount - 1 && updatedPitCount == 1) {
                    mainPit = mainPit + homePlayer.getPits().get(pit).getPit() + opponentPlayer.getPits().get(opponentPit(pit) - 1).getPit();
                    homePlayer.getMainPit().setPit(mainPit);
                    homePlayer.getPits().get(pit).setPit(0);
                    opponentPlayer.getPits().get(opponentPit(pit) - 1).setPit(0);
                }
            } else if (pit > 6) {
                currentPit = pit - 7;

                if (currentPit > 5) {
                    pit = -1;
                    i = i - 1;
                } else {
                    updatedPitCount = opponentPlayer.getPits().get(currentPit).getPit();
                    updatedPitCount += 1;
                    opponentPlayer.getPits().get(currentPit).setPit(updatedPitCount);
                }
            }

            pit++;
        }

        if (isBoardEmpty(homePlayer)) {
            opponentPlayer.getMainPit().setPit(opponentPlayer.getMainPit().getPit() + Utils.sum(opponentPlayer.pits));
            Utils.clearPits(opponentPlayer.pits);
        }

        SelectPitResponse response = SelectPitResponse.builder()
                .lastStone(lastStone)
                .opponent(opponentPlayer)
                .player(homePlayer)
                .build();

        return response;
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
