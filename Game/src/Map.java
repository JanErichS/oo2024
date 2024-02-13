import java.security.PublicKey;

public class Map {
    int mapHeight;
    int mapWidth;
    public Map(int height, int width){
        mapHeight = height;
        mapWidth = width;
    }

    public void printMap(Player player, Dragon dragon, Orc orc) {
        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWidth; x++) {
                char symbol;
                if (y == 0 || y == mapHeight - 1) {
                    symbol = '-';
                } else if (x == 0 || x == mapWidth - 1) {
                    symbol = '|';
                } else {
                    if (x == player.xCoord && y == player.yCoord) {
                        symbol = player.symbol;
                    } else if (x == dragon.xCoord && y == dragon.yCoord) {
                        symbol = dragon.symbol;
                    } else if (x == orc.xCoord && y == orc.yCoord) {
                        symbol = orc.symbol;
                    } else {
                        symbol = ' ';
                    }
                }
                System.out.print(symbol);
            }
            System.out.println();
        }
    }
}
