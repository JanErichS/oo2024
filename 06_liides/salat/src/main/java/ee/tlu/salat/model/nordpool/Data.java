package ee.tlu.salat.model.nordpool;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Data {
    // Kuna kõikides arraydes tuleb samasugune struktuur, pole mõtet teha eraldi, nagu converter soovib. Teeb ühe.
    private ArrayList<TimestampPrice> ee;
    private ArrayList<TimestampPrice> fi;
    private ArrayList<TimestampPrice> lv;
    private ArrayList<TimestampPrice> lt;
}
