package ee.tlu.viimane_kodutoo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ElementMeasurements {
    @JsonProperty("Diameter")
    public double diameter;
}
