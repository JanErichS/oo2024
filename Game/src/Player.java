import java.util.Random;
// extends võtab kõik funkts characrerist
// igal alamklassil saab olla 1 ülemklass
// Implements -> kohustab mingit funkts kasutama
// extends -> pakub võimaluse
public class Player extends Character implements RandomCoord{
    Direction direction;
    Item item; // Klassikomplekt
    Vehicle vehicle;

    public Player(Random random, int mapHeight, int mapWidth) {
        xCoord = getCoords(random, mapWidth); // Annab muutujale algväärtuse
        yCoord = getCoords(random, mapHeight);
        symbol = 'x';
        direction = Direction.UP;
    }

    /* switch kontrollib sama mutuujat eri väärtuste vastu
    Sama saab teha if-idega; Kui mitme eri muutujaga võrrelda, siis aint if-idega
    Kui ma tahaksin mitut tegevust sama sisendiga teha, siis kasutaksin seda.
    } */
    public void move(String input, Map map) {
        switch (input){
            case "w" -> direction = Direction.UP;
            case "s" -> direction = Direction.DOWN;
            case "a" -> direction = Direction.LEFT;
            case "d" -> direction = Direction.RIGHT;
        }
        // Kontrollib suunda, kui mmidagi pole muudetud jätkab samas suunas.
        switch (direction){
            case UP -> {
                if(yCoord > 1) yCoord--;
            }
            case DOWN -> {
                if (yCoord < map.mapHeight - 2) yCoord++;
            }
            case LEFT -> {
                if (xCoord > 1) xCoord--;
            }
            case RIGHT -> {
                if (xCoord < map.mapWidth - 2) xCoord++;
            }
        }
    }
    public int getCoords(Random random, int mapCoords) {
        return random.nextInt(1, mapCoords - 1);
    }
}
