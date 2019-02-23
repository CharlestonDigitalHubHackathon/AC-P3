package hackathon9.ca_p3.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Document(collection="city_temp")
public class CityTemp {

  @Id
  private String id;
  private String dt;
  private Float AverageTemperature;
  private Float AverageTemperatureUncertainty;
  private String City;
  private String Country;
  private String Latitude;
  private String Longitude;
}