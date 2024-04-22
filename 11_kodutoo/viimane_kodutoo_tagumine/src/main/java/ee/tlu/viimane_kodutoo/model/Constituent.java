package ee.tlu.viimane_kodutoo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Constituent {
    public int constituentID;
    public String role;
    public String name;
    public String constituentULAN_URL;
    public String constituentWikidata_URL;
    public String gender;
}
