package hackathon9.ca_p3.controllers;

import org.springframework.web.bind.annotation.RestController;

import hackathon9.ca_p3.models.CityTemp;
import hackathon9.ca_p3.repository.CityTempRepository;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class CityTempController {

  private CityTempRepository cityTempRepository;
  public CityTempController(CityTempRepository cityTempRepository) {
    this.cityTempRepository = cityTempRepository;
  }

  @GetMapping(value="cityTemp/{city}")
  public CityTemp getCity(@PathVariable String city) {
      return cityTempRepository.findByCityLatest(city);
  }
  
}