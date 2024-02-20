//import java.security.PublicKey;
import java.util.List;

public class Map {
    int mapHeight;
    int mapWidth;
    public Map(int height, int width){
        mapHeight = height;
        mapWidth = width;
    }

    public void printMap(List<Character> characters, List<Item> items) {
        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWidth; x++) {
                char symbol;
                if (y == 0 || y == mapHeight - 1) {
                    symbol = '-';
                } else if (x == 0 || x == mapWidth - 1) {
                    symbol = '|';
                } else {
                    symbol = ' ';
                    // Lühendatud for (each) cycle
                    for (Item e : items) {
                        if (e.xCoord == x && e.yCoord == y) {
                            symbol = e.symbol;
                        }
                    } // for loop lõpp
                    for (Character c: characters) {
                        if (c.xCoord == x && c.yCoord == y) {
                            symbol = c.symbol;
                        }
                    }
                }
                System.out.print(symbol);
            }
            System.out.println();
        }
    }
}
