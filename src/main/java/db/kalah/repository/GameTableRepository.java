package db.kalah.repository;

import db.kalah.model.db.GameTable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameTableRepository extends MongoRepository<GameTable, String> {

}
