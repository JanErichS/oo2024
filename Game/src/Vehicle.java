import java.util.Random;

public class Vehicle {
    String name;
    int speed;
    int xCoord;
    int yCoord;
    char symbol;

    public Vehicle(String name, int speed, Random random, Map map) {
        this.name = name;
        this.speed = speed;
        this.xCoord = getCoords(random, map.mapHeight);
        this.yCoord = getCoords(random, map.mapHeight);
        this.symbol = 'S';
    }

    private int getCoords(Random random, int mapCoords) {
        return random.nextInt(1, mapCoords - 1);
    }
}
