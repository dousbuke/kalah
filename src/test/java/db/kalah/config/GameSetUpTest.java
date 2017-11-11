package db.kalah.config;


import db.kalah.enums.GameStatus;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameSetUpTest {

    @Test
    public void shouldReturnStatusRunning() {

        assertThat(GameSetUp.initGame(), equalTo(GameStatus.PLAYING));

    }

}