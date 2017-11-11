package db.kalah.config;


import db.kalah.dto.request.BoardRequest;
import db.kalah.dto.response.BoardResponse;
import db.kalah.model.Board;

public class BoardSetUp {

    public static BoardResponse setUpBoards(BoardRequest request) {
        Board firstPlayerBoard = new Board(request.getBoardSize());
        Board secondPlayerBoard = new Board(request.getBoardSize());

        return BoardResponse.builder().firstPlayerBoard(firstPlayerBoard).secondPlayerBoard(secondPlayerBoard).build();
    }
}
