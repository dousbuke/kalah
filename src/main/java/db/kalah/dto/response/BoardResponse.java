package db.kalah.dto.response;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import db.kalah.model.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class BoardResponse {

    public Board firstPlayerBoard;

    public Board secondPlayerBoard;
}
