package hackathon9.ca_p3.repository;

import hackathon9.ca_p3.models.CityTemp;
import hackathon9.ca_p3.models.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item, String> {

}
