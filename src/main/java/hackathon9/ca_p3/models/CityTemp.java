package hackathon9.ca_p3.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class CityTemp {

  @Id
  private String id;

  private Date dt;
  private Float AverageTemperature;
  private Float AverageTemperatureUncertainty;
  private String City;
  private String Country;
  private String Latitude;
  private String Longitude;
}