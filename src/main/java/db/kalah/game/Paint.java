package db.kalah.game;

import db.kalah.model.Board;


public class Paint {

    private Board firstPlayer;

    private Board secondPlayer;

    public Paint(Board firstPlayer, Board secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public void paint() {

        paintFirstPlayerBoard(firstPlayer);

        System.out.println();
        System.out.print("-------------------------------------\n");

        System.out.println();
        System.out.println();

        System.out.print("-------------------------------------\n");
        paintSecondPlayerBoard(secondPlayer);

        System.out.println();
        System.out.println();

    }

    private void paintFirstPlayerBoard(Board playerBoard) {
        System.out.print("------------First Player-------------\n");
        System.out.print(playerBoard.getMainPit().getPitName() + " | " );
        for (int i = 5; i >= 0; i--) {
            System.out.print(playerBoard.getPits().get(i).getPitName() + " | " );
        }
        System.out.println();
        System.out.print("-------------------------------------\n");

        System.out.print(playerBoard.getMainPit().getPit() + "    | ");
        for (int i = 5; i >= 0; i--) {
            System.out.print(playerBoard.getPits().get(i).getPit() + "  | " );
        }
    }

    private void paintSecondPlayerBoard(Board playerBoard) {
        for (int i = 0; i < playerBoard.size; i++) {
            System.out.print(playerBoard.getPits().get(i).getPit() + "  | " );
        }

        System.out.print(" | " + playerBoard.getMainPit().getPit() + "\n");
        System.out.print("-------------------------------------\n");

        for (int i = 0; i < playerBoard.size; i++) {
            System.out.print(playerBoard.getPits().get(i).getPitName() + " | " );
        }

        System.out.print(" | " + playerBoard.getMainPit().getPitName() + "\n");
        System.out.print("------------Second Player------------\n");
    }
}
