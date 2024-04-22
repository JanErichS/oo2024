package ee.tlu.salat.model.nordpool;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TimestampPrice {
    private int timestamp;
    private double price;
}
