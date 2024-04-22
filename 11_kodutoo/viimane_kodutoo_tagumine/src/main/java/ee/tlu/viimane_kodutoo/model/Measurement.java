package ee.tlu.viimane_kodutoo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Measurement {
    public String elementName;
    public String elementDescription;
    public ElementMeasurements elementMeasurements;
}
