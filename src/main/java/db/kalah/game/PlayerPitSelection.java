package db.kalah.game;


import db.kalah.model.Board;

import java.util.Scanner;

public class PlayerPitSelection {

    private static Scanner input = new Scanner(System.in);

    public static boolean playerPitSelection(Board firstPlayer, Board secondPlayer) {
        int pit = 0;
        boolean validInput = false;

        do {
            try {
                System.out.print("Select pit : ");
                pit = Integer.parseInt(input.nextLine());
                System.out.println();
                if (pit > 6 || pit < 1) {
                    System.out.println("Selected pit is wrong. Please select pit");
                    validInput = false;
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        } while (!validInput);

        return PlayerMovement.movement(pit, firstPlayer, secondPlayer);
    }

}
