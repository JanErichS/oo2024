package ee.tlu.viimane_kodutoo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AllPaintings {
    public int total;
    public ArrayList<Integer> objectIDs;
}
