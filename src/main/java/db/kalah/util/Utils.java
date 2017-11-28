package db.kalah.util;


import db.kalah.model.Pit;

import java.util.List;

public class Utils {

    public static Integer sum(List<Pit> list) {
        if (list == null || list.size() < 1)
            return 0;

        int sum = 0;

        for (Pit i : list) {
            sum += i.getPit();
        }

        return sum;
    }

    public static void clearPits(List<Pit> list) {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setPit(0);
        }
    }

    public static int opponentPitMap(int pit) {
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
