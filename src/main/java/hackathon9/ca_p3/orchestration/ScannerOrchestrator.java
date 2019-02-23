package hackathon9.ca_p3.orchestration;

import hackathon9.ca_p3.models.BarcodeInformation;
import hackathon9.ca_p3.models.Item;
import hackathon9.ca_p3.models.ScannedItem;
import hackathon9.ca_p3.repository.ItemRepository;
import hackathon9.ca_p3.repository.ScannedItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScannerOrchestrator {

    private final ItemRepository itemRepository;
    private final ScannedItemRepository scannedItemRepository;

    @Autowired
    public ScannerOrchestrator(ItemRepository itemRepository, ScannedItemRepository scannedItemRepository) {
        this.itemRepository = itemRepository;
        this.scannedItemRepository = scannedItemRepository;
    }

    public String getScannedItem(String identifier){
        return "";
    }

    public List<ScannedItem> listScannedItemsByUser(String userId){
        return scannedItemRepository.findAllByUserId(userId);
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
