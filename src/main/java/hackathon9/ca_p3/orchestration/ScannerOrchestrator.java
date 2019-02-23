package hackathon9.ca_p3.orchestration;

import hackathon9.ca_p3.models.Item;
import hackathon9.ca_p3.models.ScannedItem;
import hackathon9.ca_p3.repository.ItemRepository;
import hackathon9.ca_p3.repository.ScannedItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
public class ScannerOrchestrator {

    private final ItemRepository itemRepository;

    private final ScannedItemRepository scannedItemRepository;

    @Autowired
    public ScannerOrchestrator(ItemRepository itemRepository, ScannedItemRepository scannedItemRepository) {
        this.itemRepository = itemRepository;
        this.scannedItemRepository = scannedItemRepository;
    }

    public List<Item> listScannedItemsByUser(UUID userId) {
        List<ScannedItem> scannedItems = scannedItemRepository.findAllByUserId(userId);
        List<Item> usersItemsScanned = new ArrayList<>();
        scannedItems.stream().forEach(scannedItem -> {
            usersItemsScanned.add(itemRepository.findById(scannedItem.getBarcodeIdentifier()).orElse(null));
        });
        return usersItemsScanned;
    }

    public void saveScannedItem(UUID userId, String itemId) {
        ScannedItem scannedItem = new ScannedItem();
        scannedItem.setUserId(userId);
        scannedItem.setBarcodeIdentifier(itemId);
        scannedItem.setScannedDate(new Date());
        scannedItem.setUuid(UUID.randomUUID());
        scannedItemRepository.save(scannedItem);
    }

    public void registerItem(String itemId, String itemName, String itemType) {
        Item item = new Item();
        item.setItemId(itemId);
        item.setItemName(itemName);
        item.setType(itemType);
        itemRepository.save(item);
    }

    public Item getItem(String itemId) {
        return itemRepository.findById(itemId).orElse(null);
    }
}
