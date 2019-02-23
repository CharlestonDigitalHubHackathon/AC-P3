package hackathon9.ca_p3.controllers;

import hackathon9.ca_p3.models.Item;
import hackathon9.ca_p3.orchestration.ScannerOrchestrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ScannerController {

    private final ScannerOrchestrator scannerOrchestrator;

    @Autowired
    public ScannerController(ScannerOrchestrator scannerOrchestrator) {
        this.scannerOrchestrator = scannerOrchestrator;
    }

    @PostMapping(value = "registerItem/{itemId}/{name}/{type}")
    public void registerItem(@PathVariable String itemId, @PathVariable String name, @PathVariable String type){
        scannerOrchestrator.registerItem(itemId, name, type);
    }

    @GetMapping(value = "getItem/{itemId}")
    public Item getItem(@PathVariable String itemId){
        return scannerOrchestrator.getItem(itemId);
    }

    @GetMapping(value = "scanItem/{itemId}")
    public void scanItem(@PathVariable String itemId, @CookieValue("userId") UUID userId) {
        scannerOrchestrator.saveScannedItem(userId, itemId);
    }

}
