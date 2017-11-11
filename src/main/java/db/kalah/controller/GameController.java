package db.kalah.controller;

import db.kalah.config.BoardSetUp;
import db.kalah.config.GameSetUp;
import db.kalah.dto.request.BoardRequest;
import db.kalah.dto.request.GameStatusCheckRequest;
import db.kalah.dto.request.SelectPitRequest;
import db.kalah.dto.response.BoardResponse;
import db.kalah.dto.response.GameStatusCheckResponse;
import db.kalah.dto.response.SelectPitResponse;
import db.kalah.enums.GameStatus;
import db.kalah.game.GameStatusCheck;
import db.kalah.game.PlayerMovement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/game")
public class GameController {

    @PostMapping("init-board")
    public ResponseEntity initBoard(@Valid @RequestBody BoardRequest request) {
        BoardResponse response = BoardSetUp.setUpBoards(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("init")
    public ResponseEntity initGame(){
        GameStatus status = GameSetUp.initGame();
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PostMapping("select-pit")
    public ResponseEntity selectPit(@Valid @RequestBody SelectPitRequest request) {
        SelectPitResponse response = null;
        try {
            response = PlayerMovement.selectPitResponse(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("status-check")
    public ResponseEntity gameStatusCheck(@Valid @RequestBody GameStatusCheckRequest request) {
        GameStatusCheckResponse response = GameStatusCheck.gameStatusCheck(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
