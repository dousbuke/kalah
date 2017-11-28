package db.kalah.model.db;


import db.kalah.model.Board;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;


public class GameTable {

    @Id
    private String id;

    private Board firstPlayerBoard;

    private Board secondPlayerBoard;

    private LocalDateTime dateTime;

    public GameTable() {
    }

    public GameTable(String id, Board firstPlayerBoard, Board secondPlayerBoard, LocalDateTime dateTime) {
        this.id = id;
        this.firstPlayerBoard = firstPlayerBoard;
        this.secondPlayerBoard = secondPlayerBoard;
        this.dateTime = dateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Board getFirstPlayerBoard() {
        return firstPlayerBoard;
    }

    public void setFirstPlayerBoard(Board firstPlayerBoard) {
        this.firstPlayerBoard = firstPlayerBoard;
    }

    public Board getSecondPlayerBoard() {
        return secondPlayerBoard;
    }

    public void setSecondPlayerBoard(Board secondPlayerBoard) {
        this.secondPlayerBoard = secondPlayerBoard;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "GameTable{" +
                "id='" + id + '\'' +
                ", firstPlayerBoard=" + firstPlayerBoard +
                ", secondPlayerBoard=" + secondPlayerBoard +
                ", dateTime=" + dateTime +
                '}';
    }
}
