package db.kalah.dto.request;

import db.kalah.enums.Players;
import db.kalah.model.Board;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectPitRequest {

    private Players players;

    private Integer pit;

    public Board player;

    public Board opponent;

}
