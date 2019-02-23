package hackathon9.ca_p3.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import hackathon9.ca_p3.models.CityTemp;
import java.util.List;

public interface CityTempRepository extends MongoRepository<CityTemp, String> {
  @Query(value = "{ 'City' : ?0 }", sort = "{ dt : -1 }")
  List<CityTemp> findByCity(String city);

  public default CityTemp findByCityLatest(String city){
    return findByCity(city).get(0);
  }
}