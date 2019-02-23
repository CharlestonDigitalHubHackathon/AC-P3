package hackathon9.ca_p3.models;

import lombok.Data;

import java.util.Date;

@Data
public class ScannedInformation {
    BarcodeInformation barcodeInformation;
    Date scanDate;
}