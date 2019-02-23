package hackathon9.ca_p3.models;
import lombok.Data;

import java.util.UUID;

@Data
public class User {
    UUID userId;
    String phoneNumber;
}
