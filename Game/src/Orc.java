import java.util.Random;

public class Orc extends Character implements RandomCoord{
    // Konstruktor
    public Orc(Random random, int mapHeight, int mapWidth) {
        xCoord = getCoords(random, mapWidth); // Annab muutujale algväärtuse
        yCoord = getCoords(random, mapHeight);
        symbol = 'O';
    }

    public int getCoords(Random random, int mapCoords) {
        return random.nextInt(1, mapCoords - 1);
    }
}
