package hackathon9.ca_p3.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserHistoryController {

    List<String> getScannedItemsByUser(String userId){
        return new ArrayList<>();
    }

}
