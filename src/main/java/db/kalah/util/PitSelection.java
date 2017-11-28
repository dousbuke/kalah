package db.kalah.util;


import db.kalah.exceptions.GameError;
import db.kalah.exceptions.GameException;
import db.kalah.model.Board;

import java.util.Scanner;

public class PitSelection {

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
                e.getMessage();
                e.printStackTrace();
            } catch (GameException e) {
                validInput = false;
                e.getMessage();
                e.printStackTrace();
            }
        } while (!validInput);

        return pit;
    }

    private static boolean checkForValidInput(int pit) throws NumberFormatException {
        try {
            if (pit > 6 || pit < 1) {
                throw new NumberFormatException("Pit is not valid. Try again");
            }
            return true;
        } catch (NumberFormatException e) {
            throw e;
        }
    }

    public static boolean validPit(Board board, Integer pit) throws GameException {
        try {
            if (board.getPits().get(pit - 1).getPit() == 0) {
                throw new GameException(GameError.EMPTY_PIT_CANNOT_PLAY);
            }
            return true;
        } catch (GameException exception) {
            exception.getLocalizedMessage();

            throw exception;
        }
    }

}
