package hackathon9.ca_p3.repository;

import hackathon9.ca_p3.models.Reward;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface RewardRepository extends MongoRepository<Reward, UUID> {

}
