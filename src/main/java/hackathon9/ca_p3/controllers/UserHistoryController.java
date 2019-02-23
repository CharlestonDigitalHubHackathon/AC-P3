package hackathon9.ca_p3.controllers;

import hackathon9.ca_p3.models.Item;
import hackathon9.ca_p3.orchestration.ScannerOrchestrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class UserHistoryController {

    private final ScannerOrchestrator scannerOrchestrator;

    @Autowired
    public UserHistoryController(ScannerOrchestrator scannerOrchestrator) {
        this.scannerOrchestrator = scannerOrchestrator;
    }

    @GetMapping(value = "/getUserHistory")
    List<Item> getScannedItemsByUser(@CookieValue("userId") UUID userId) {
        return scannerOrchestrator.listScannedItemsByUser(userId);
    }
}
