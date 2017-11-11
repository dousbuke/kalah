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
}
