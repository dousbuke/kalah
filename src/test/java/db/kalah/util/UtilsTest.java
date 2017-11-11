package db.kalah.util;

import db.kalah.model.Pit;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class UtilsTest {

    @Test
    public void shouldSum() {
        Pit pit1 = Pit.builder().pitName("1P").pit(5).build();
        Pit pit2 = Pit.builder().pitName("2P").pit(10).build();
        Pit pit3 = Pit.builder().pitName("3P").pit(20).build();

        List<Pit> pitList = new ArrayList<>();
        pitList.add(pit1);
        pitList.add(pit2);
        pitList.add(pit3);

        assertThat(Utils.sum(pitList), equalTo(35));
    }

    @Test
    public void shouldSetZeroToAllElementsInPitList() {
        Pit pit1 = Pit.builder().pitName("1P").pit(5).build();
        Pit pit2 = Pit.builder().pitName("2P").pit(10).build();
        Pit pit3 = Pit.builder().pitName("3P").pit(20).build();

        List<Pit> pitList = new ArrayList<>();
        pitList.add(pit1);
        pitList.add(pit2);
        pitList.add(pit3);

        Utils.clearPits(pitList);

        assertThat(pitList.get(0).getPit(), equalTo(0));
        assertThat(pitList.get(1).getPit(), equalTo(0));
        assertThat(pitList.get(2).getPit(), equalTo(0));
    }
}