package db.kalah;


import db.kalah.game.PlayGame;
import db.kalah.model.Board;
import db.kalah.model.db.GameTable;
import db.kalah.repository.GameTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
@EnableMongoRepositories
public class Application implements CommandLineRunner {

    @Autowired
    private GameTableRepository gameTableRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        Integer pitCount = 6;
        Integer defaultPitSize = 6;

        GameTable gameTable = new GameTable();
            gameTable.setId("Game"+ Math.random());
            gameTable.setDateTime(LocalDateTime.now());
            gameTable.setFirstPlayerBoard(new Board());
            gameTable.setSecondPlayerBoard(new Board());

        gameTableRepository.insert(gameTable);
        
        List<GameTable> gameTableList = gameTableRepository.findAll();

        PlayGame playGame = new PlayGame(pitCount, defaultPitSize);
        playGame.playGame();
    }

}
