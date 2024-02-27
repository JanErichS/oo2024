import java.util.List;
import java.util.ArrayList;
public class Triangle {
    List<Integer> xCoords = new ArrayList<>();
    List<Integer> yCoords = new ArrayList<>();

    public Triangle(List<Integer> xCoords, List<Integer> yCoords) {
        this.xCoords = xCoords;
        this.yCoords = yCoords;
    }

    // Lisa klassile käsklus punkti koordinaadipaari lisamiseks. Käsklusena väljasta tekkiva hulknurga ümbermõõt (küljepikkuste summa).

    public void addCoordPair(int x, int y){
        xCoords.add(x);
        yCoords.add(y);
    }
    //public double findCir(){

    //}

    public List<Double> distance(List<Integer> xCoords, List<Integer> yCoords){
        // sqrt( (x2 - x1)^2 + (y2 - y1)^2)
        List<Double> distances = new ArrayList<>();
        double tempX;
        double tempY;

        for (int i = 0; i < xCoords.size(); i++) {
            tempX = Math.sqrt((xCoords.get(i) - xCoords.get(i+1))^2);
            tempY = Math.sqrt((yCoords.get(i) - yCoords.get(i+1))^2);
            distances.add(tempX+tempY);
        }
        return distances;
    }
}
