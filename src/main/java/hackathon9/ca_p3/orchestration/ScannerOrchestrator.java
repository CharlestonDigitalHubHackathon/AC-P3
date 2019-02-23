package hackathon9.ca_p3.orchestration;

import hackathon9.ca_p3.models.BarcodeInformation;
import hackathon9.ca_p3.models.Item;
import hackathon9.ca_p3.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ScannerOrchestrator {

    private final ItemRepository itemRepository;

    @Autowired
    public ScannerOrchestrator(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public String getScannedItem(String identifier){
        return "";
    }

    public String saveScannedItem(BarcodeInformation barcodeInformation){
        return "";
    }

    public void registerItem(String itemId, String itemName){
        Item item = new Item();
        item.setItemId(itemId);
        item.setItemName(itemName);
        itemRepository.save(item);
    }

    public Item getItem(String itemId) {
        return itemRepository.findById(itemId).orElse(null);
    }
}
