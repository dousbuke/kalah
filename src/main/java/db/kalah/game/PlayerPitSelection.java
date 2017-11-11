package db.kalah.game;


public class PlayerPitSelection {

    public static boolean validatePit(Integer pit) {

        if (pit > 6 || pit < 1) {
            return false;
        } else {
            return true;
        }
    }
}
