import java.util.Random;

public class Dragon extends Character{
    // Konstruktor
    public Dragon(Random random, int mapHeight, int mapWidth) {
        xCoord = getCoords(random, mapWidth); // Annab muutujale algväärtuse
        yCoord = getCoords(random, mapHeight);
        symbol = 'D';
    }
    private int getCoords(Random random, int mapCoords) {
        return random.nextInt(1, mapCoords - 1);
    }
}
