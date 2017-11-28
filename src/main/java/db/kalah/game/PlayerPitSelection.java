package db.kalah.game;


import db.kalah.exceptions.GameError;
import db.kalah.exceptions.GameException;
import db.kalah.model.Board;

import java.util.Scanner;

public class PlayerPitSelection {

    private static Scanner input = new Scanner(System.in);

    public static Integer playerPitSelection(Board board) {
        int pit = 0;
        boolean validInput = false;

        do {
            try {
                System.out.print("Select pit : ");
                pit = Integer.parseInt(input.nextLine());
                System.out.println();

                validInput = checkForValidInput(pit);
                validInput = validPit(board, pit);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        } while (!validInput);

        return pit;
    }

    private static boolean checkForValidInput(int pit) {
        if (pit > 6 || pit < 1) {
            System.out.println("Selected pit is wrong. Please select pit");
            return false;
        } else {
            return true;
        }
    }

    public static boolean validPit(Board board, Integer pit) {
        try {
            if (board.getPits().get(pit - 1).getPit() == 0) {
                throw new GameException(GameError.EMPTY_PIT_CANNOT_PLAY);
            }
            return true;
        } catch (GameException exception) {
            exception.printStackTrace();
        }
        return false;
    }

}
