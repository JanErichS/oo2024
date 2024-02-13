import java.util.Random;
import java.util.Scanner;

// Kui valid Tab-iga, siis impordib ise
// var.equals() -> == ; !var.equals() -> !=; "end" == "end" ei tohi panna, pole sama
public class Main {
    public static void main(String[] args) {

        // Tüüp klass = new Klassinimi();
        Random random = new Random();
        Map map = new Map(5,10);
        Scanner scanner = new Scanner(System.in);

        // Characters
        Player player = new Player(random, map.mapHeight, map.mapWidth);
        Dragon dragon = new Dragon(random, map.mapHeight, map.mapWidth);
        Orc orc = new Orc(random, map.mapHeight, map.mapWidth);

        // Esimene kuvamine
        map.printMap(player, dragon, orc);
        String input = scanner.nextLine();
        player.move(input, map);

        // Liikumisloogika
        while (!input.equals("end")) {
            map.printMap(player, dragon, orc);
            input = scanner.nextLine();
            player.move(input, map);
        }
    } // main (args[])
} // Main ()