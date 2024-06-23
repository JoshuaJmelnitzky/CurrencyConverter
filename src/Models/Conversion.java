package Models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Conversion {
    String conversion_rate;
    String base_code;
    String target_code;
    String time;
    float total;
    float qty;

    public Conversion(String conversion_rate, String base_code, String target_code) {
        this.conversion_rate = conversion_rate;
        this.base_code = base_code;
        this.target_code = target_code;
        this.time = currentTime();
    }

    public String currentTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return "[" + now.format(formatter) + "] ";
    }

    public String getConversion_rate() {
        return conversion_rate;
    }

    public String getBase_code() {
        return base_code;
    }

    public String getTarget_code() {
        return target_code;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getQty() {
        return qty;
    }

    public void setQty(float qty) {
        this.qty = qty;
    }
}
