package hackathon9.ca_p3.controllers;

import hackathon9.ca_p3.models.BarcodeInformation;
import hackathon9.ca_p3.orchestration.ScannerOrchestrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScannerController {

    private final ScannerOrchestrator scannerOrchestrator;

    @Autowired
    public ScannerController(ScannerOrchestrator scannerOrchestrator) {
        this.scannerOrchestrator = scannerOrchestrator;
    }

    @PostMapping(value = "scanItem/{itemId}")
    public String scanItem(@PathVariable String itemId) {
        BarcodeInformation barcodeInformation = new BarcodeInformation();
        barcodeInformation.setIdentifier(itemId);
        return scannerOrchestrator.saveScannedItem(barcodeInformation);
    }

}
