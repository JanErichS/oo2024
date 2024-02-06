import java.util.Random;
import java.util.Scanner;

// Kui valid Tab-iga, siis impordib ise
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        int mapHeight = 5;
        int mapWidth = 10;

        // Player character
        int playerXCoord = getCoords(random, mapWidth);
        int playerYCoord = getCoords(random, mapHeight);
        char playerSymbol = 'x';

        // Enemy characters
        int dragonXCoord = getCoords(random, mapWidth);
        int dragonYCoord = getCoords(random, mapHeight);
        char dragonSymbol = 'D';

        int orcXCoord = getCoords(random, mapWidth);
        int orcYCoord = getCoords(random, mapHeight);
        char orcSymbol = 'O';

        Scanner scanner = new Scanner(System.in);

        printMap(mapHeight, mapWidth, playerXCoord, playerYCoord, playerSymbol, dragonXCoord, dragonYCoord, dragonSymbol, orcXCoord, orcYCoord, orcSymbol);
        String input = scanner.nextLine();

        /* switch kontrollib sama mutuujat eri väärtuste vastu
        Sama saab teha if-idega; Kui mitme eri muutujaga võrrelda, siis aint if-idega
        Kui ma tahaksin mitut tegevust sama sisendiga teha, siis kasutaksin seda.
        switch (input) {
            case "w":
                playerYCoord--;
                break;
            case "s":
                playerYCoord++;
                break;
            case "a":
                playerXCoord--;
                break;
            case "d":
                playerXCoord++;
                break;
        } */

        switch (input){
            case "w" -> playerYCoord--;
            case "s" -> playerYCoord++;
            case "a" -> playerXCoord--;
            case "d" -> playerXCoord++;
        }

        // var.equals() -> == ; !var.equals() -> !=
        while (!input.equals("end")) {
            printMap(mapHeight, mapWidth, playerXCoord, playerYCoord, playerSymbol, dragonXCoord, dragonYCoord, dragonSymbol, orcXCoord, orcYCoord, orcSymbol);
            input = scanner.nextLine();
            switch (input){
                case "w" -> playerYCoord--;
                case "s" -> playerYCoord++;
                case "a" -> playerXCoord--;
                case "d" -> playerXCoord++;
            }
        }
    } // main (args[])

    private static void printMap(int mapHeight, int mapWidth, int playerXCoord, int playerYCoord, char playerSymbol, int dragonXCoord, int dragonYCoord, char dragonSymbol, int orcXCoord, int orcYCoord, char orcSymbol) {
        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWidth; x++) {
                char symbol;
                if (y == 0 || y == mapHeight - 1) {
                    symbol = '-';
                } else if (x == 0 || x == mapWidth - 1) {
                    symbol = '|';
                } else {
                    if (x == playerXCoord && y == playerYCoord) {
                        symbol = playerSymbol;
                    } else if (x == dragonXCoord && y == dragonYCoord) {
                        symbol = dragonSymbol;
                    } else if (x == orcXCoord && y == orcYCoord) {
                        symbol = orcSymbol;
                    } else {
                        symbol = ' ';
                    }
                }
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

    private static int getCoords(Random random, int mapCoords) {
        return random.nextInt(1, mapCoords - 1);
    }
} // Main ()