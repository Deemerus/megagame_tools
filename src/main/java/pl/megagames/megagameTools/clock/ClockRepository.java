package pl.megagames.megagameTools.clock;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClockRepository extends MongoRepository<Clock, String> {
}
