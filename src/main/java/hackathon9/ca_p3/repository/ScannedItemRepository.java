package hackathon9.ca_p3.repository;

import hackathon9.ca_p3.models.ScannedItem;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface ScannedItemRepository extends MongoRepository<ScannedItem, String> {
    List<ScannedItem> findAllByUserId(UUID userId);
}
