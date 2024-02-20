import java.util.Random;

public class Item {
    String name;
    double strength;
    int usage;
    boolean active;
    int xCoord;
    int yCoord;
    char symbol;

    public Item(String name, double strength, int usage, boolean active, Random random, Map map) {
        this.name = name;
        this.strength = strength;
        this.usage = usage;
        this.active = true;
        xCoord = getCoords(random, map.mapHeight);
        yCoord = getCoords(random, map.mapHeight);
        this.symbol = 'I';
    }

    public void hit(){
        System.out.println("Pauhti");
    }

    private int getCoords(Random random, int mapCoords) {
        return random.nextInt(1, mapCoords - 1);
    }
}
