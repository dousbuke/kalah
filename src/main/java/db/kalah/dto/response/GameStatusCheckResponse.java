package db.kalah.dto.response;

import db.kalah.enums.GameStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GameStatusCheckResponse {

    private GameStatus status;
}
