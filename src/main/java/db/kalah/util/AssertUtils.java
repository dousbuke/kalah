package db.kalah.util;


import db.kalah.exceptions.GameError;
import db.kalah.exceptions.GameException;

public final class AssertUtils {

    public static void assertZero(Object object, GameError gameError) {
        try {
            if(object.equals(0)) {
                throw new GameException(gameError);
            }

        } catch (GameException exception) {
            exception.printStackTrace();
        }
    }
}
