package db.kalah.model;


import java.io.Serializable;

public class PlayerBoards implements Serializable {

    private static final long serialVersionUID = -3371690757228807856L;

    private Board firstPlayerBoard;

    private Board secondPlayerBoard;

    public PlayerBoards(Board firstPlayerBoard, Board secondPlayerBoard) {
        this.firstPlayerBoard = firstPlayerBoard;
        this.secondPlayerBoard = secondPlayerBoard;
    }

    public PlayerBoards(Integer boardSize) {
        this.firstPlayerBoard = new Board(boardSize);
        this.secondPlayerBoard = new Board(boardSize);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlayerBoards that = (PlayerBoards) o;

        if (firstPlayerBoard != null ? !firstPlayerBoard.equals(that.firstPlayerBoard) : that.firstPlayerBoard != null)
            return false;
        return secondPlayerBoard != null ? secondPlayerBoard.equals(that.secondPlayerBoard) : that.secondPlayerBoard == null;
    }

    @Override
    public int hashCode() {
        int result = firstPlayerBoard != null ? firstPlayerBoard.hashCode() : 0;
        result = 31 * result + (secondPlayerBoard != null ? secondPlayerBoard.hashCode() : 0);
        return result;
    }
}
