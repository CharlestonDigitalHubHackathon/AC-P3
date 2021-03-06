package hackathon9.ca_p3.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document
public class RewardItem {
    @Id
    UUID uuid;
    String title;
    Integer cost;
}
