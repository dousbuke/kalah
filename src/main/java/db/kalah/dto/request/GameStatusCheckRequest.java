package db.kalah.dto.request;

import db.kalah.model.Board;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameStatusCheckRequest {

    public Board firstPlayerBoard;

    public Board secondPlayerBoard;
}
