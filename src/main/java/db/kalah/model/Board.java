package db.kalah.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Board {

    public List<Pit> pits;

    public Pit mainPit;

    public int size;

    public Board(int size) {
        this.size = size;
        this.pits = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Pit pit = Pit.builder()
                    .pitName(String.valueOf(i+1)+"P")
                    .pit(6)
                    .build();

            this.pits.add(i, pit);
        }
        mainPit = new Pit("Main", 0);
    }

}
