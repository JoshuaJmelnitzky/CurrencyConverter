package Models;

import java.util.ArrayList;
import java.util.List;

public class HistoricalRecord {
    private List<Conversion> conversions;

    public HistoricalRecord() {
        this.conversions = new ArrayList<>();
    }

    public void addConversion(Conversion conversion) {
        conversions.add(conversion);
    }

    public List<Conversion> getConversions() {
        return conversions;
    }

}
