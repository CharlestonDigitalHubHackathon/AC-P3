package hackathon9.ca_p3.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Item {
    @Id
    String itemId;
    String itemName;
}
