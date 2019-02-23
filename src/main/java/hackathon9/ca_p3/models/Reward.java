package hackathon9.ca_p3.models;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
public class Reward {
    @Id
    UUID userId;
    int pointTotal;
}
