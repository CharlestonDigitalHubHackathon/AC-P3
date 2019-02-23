package hackathon9.ca_p3.controllers;

import hackathon9.ca_p3.models.ScannedItem;
import hackathon9.ca_p3.orchestration.ScannerOrchestrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserHistoryController {

    private final ScannerOrchestrator scannerOrchestrator;

    @Autowired
    public UserHistoryController(ScannerOrchestrator scannerOrchestrator) {
        this.scannerOrchestrator = scannerOrchestrator;
    }

    List<ScannedItem> getScannedItemsByUser(String userId){
        return scannerOrchestrator.listScannedItemsByUser(userId);
    }
}
