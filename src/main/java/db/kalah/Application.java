package db.kalah;


import db.kalah.game.PlayGame;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        Integer pitCount = 6;
        Integer defaultPitSize = 6;

        PlayGame playGame = new PlayGame(pitCount, defaultPitSize);
        playGame.playGame();
    }

}
