package db.kalah.game;

import db.kalah.enums.GameStatus;
import db.kalah.model.Board;
import db.kalah.model.Pit;
import db.kalah.model.PlayerBoards;
import db.kalah.status.GameStatusCheck;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GameStatusCheckTest {

    @Test
    public void shouldCheckForGameStatusFirstPlayerWins() {
        Pit pit1 = Pit.builder().pitName("1P").pit(0).build();
        Pit pit2 = Pit.builder().pitName("2P").pit(0).build();
        Pit pit3 = Pit.builder().pitName("3P").pit(0).build();

        List<Pit> pitList = new ArrayList<>();
        pitList.add(pit1);
        pitList.add(pit2);
        pitList.add(pit3);

        Pit firstPlayerMainPit = Pit.builder().pitName("Main").pit(25).build();

        Pit secondPlayerMainPit = Pit.builder().pitName("Main").pit(20).build();

        Board firstPlayerBoard = new Board();
        firstPlayerBoard.setSize(3);
        firstPlayerBoard.setMainPit(firstPlayerMainPit);
        firstPlayerBoard.setPits(pitList);

        Board secondPlayerBoard = new Board();
        secondPlayerBoard.setSize(3);
        secondPlayerBoard.setMainPit(secondPlayerMainPit);
        secondPlayerBoard.setPits(pitList);

        PlayerBoards playerBoards = new PlayerBoards(firstPlayerBoard, secondPlayerBoard);

        GameStatus status = GameStatusCheck.checkGameStatusByPitNumber(playerBoards);

        assertThat(status, equalTo(GameStatus.FIRST_PLAYER_WIN));
    }

    @Test
    public void shouldCheckForGameStatusSecondPlayerWins() {
        Pit pit1 = Pit.builder().pitName("1P").pit(0).build();
        Pit pit2 = Pit.builder().pitName("2P").pit(0).build();
        Pit pit3 = Pit.builder().pitName("3P").pit(0).build();

        List<Pit> pitList = new ArrayList<>();
        pitList.add(pit1);
        pitList.add(pit2);
        pitList.add(pit3);

        Pit firstPlayerMainPit = Pit.builder().pitName("Main").pit(25).build();
        Pit secondPlayerMainPit = Pit.builder().pitName("Main").pit(30).build();

        Board firstPlayerBoard = new Board();
        firstPlayerBoard.setSize(3);
        firstPlayerBoard.setMainPit(firstPlayerMainPit);
        firstPlayerBoard.setPits(pitList);

        Board secondPlayerBoard = new Board();
        secondPlayerBoard.setSize(3);
        secondPlayerBoard.setMainPit(secondPlayerMainPit);
        secondPlayerBoard.setPits(pitList);

        PlayerBoards playerBoards = new PlayerBoards(firstPlayerBoard, secondPlayerBoard);

        GameStatus status = GameStatusCheck.checkGameStatusByPitNumber(playerBoards);

        assertThat(status, equalTo(GameStatus.SECOND_PLAYER_WIN));
    }

    @Test
    public void shouldCheckForGameStatusDraw() {
        Pit pit1 = Pit.builder().pitName("1P").pit(0).build();
        Pit pit2 = Pit.builder().pitName("2P").pit(0).build();
        Pit pit3 = Pit.builder().pitName("3P").pit(0).build();

        List<Pit> pitList = new ArrayList<>();
        pitList.add(pit1);
        pitList.add(pit2);
        pitList.add(pit3);

        Pit firstPlayerMainPit = Pit.builder().pitName("Main").pit(25).build();
        Pit secondPlayerMainPit = Pit.builder().pitName("Main").pit(25).build();

        Board firstPlayerBoard = new Board();
        firstPlayerBoard.setSize(3);
        firstPlayerBoard.setMainPit(firstPlayerMainPit);
        firstPlayerBoard.setPits(pitList);

        Board secondPlayerBoard = new Board();
        secondPlayerBoard.setSize(3);
        secondPlayerBoard.setMainPit(secondPlayerMainPit);
        secondPlayerBoard.setPits(pitList);

        PlayerBoards playerBoards = new PlayerBoards(firstPlayerBoard, secondPlayerBoard);

        GameStatus status = GameStatusCheck.checkGameStatusByPitNumber(playerBoards);

        assertThat(status, equalTo(GameStatus.DRAW));
    }

    @Test
    public void shouldCheckForGameStatusPlayingIfPitsAreNotEmpty() {
        Pit pit1 = Pit.builder().pitName("1P").pit(10).build();
        Pit pit2 = Pit.builder().pitName("2P").pit(0).build();
        Pit pit3 = Pit.builder().pitName("3P").pit(5).build();

        Pit pitP1 = Pit.builder().pitName("1P").pit(0).build();
        Pit pitP2 = Pit.builder().pitName("2P").pit(0).build();
        Pit pitP3 = Pit.builder().pitName("3P").pit(0).build();

        List<Pit> pitList = new ArrayList<>();
        pitList.add(pit1);
        pitList.add(pit2);
        pitList.add(pit3);

        List<Pit> pitListP2 = new ArrayList<>();
        pitList.add(pitP1);
        pitList.add(pitP2);
        pitList.add(pitP3);

        Pit firstPlayerMainPit = Pit.builder().pitName("Main").pit(25).build();
        Pit secondPlayerMainPit = Pit.builder().pitName("Main").pit(25).build();

        Board firstPlayerBoard = new Board();
        firstPlayerBoard.setSize(3);
        firstPlayerBoard.setMainPit(firstPlayerMainPit);
        firstPlayerBoard.setPits(pitList);

        Board secondPlayerBoard = new Board();
        secondPlayerBoard.setSize(3);
        secondPlayerBoard.setMainPit(secondPlayerMainPit);
        secondPlayerBoard.setPits(pitListP2);

        PlayerBoards playerBoards = new PlayerBoards(firstPlayerBoard, secondPlayerBoard);

        GameStatus status = GameStatusCheck.checkGameStatusByPitNumber(playerBoards);

        assertThat(status, equalTo(GameStatus.PLAYING));
    }

}