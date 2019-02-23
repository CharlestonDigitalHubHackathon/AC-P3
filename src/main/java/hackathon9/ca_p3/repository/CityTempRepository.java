package hackathon9.ca_p3.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import hackathon9.ca_p3.models.CityTemp;

public interface CityTempRepository extends MongoRepository<CityTemp, String> {

}