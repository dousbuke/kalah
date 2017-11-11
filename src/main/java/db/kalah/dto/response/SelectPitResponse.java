package db.kalah.dto.response;


import db.kalah.model.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SelectPitResponse {

    private Board player;

    private Board opponent;

    private boolean lastStone;

}
