import java.util.ArrayList;
import java.util.List;
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

        // Character list
        List<Character>  characters = new ArrayList<>();
        characters.add(player);
        characters.add(dragon);
        characters.add(orc);

        // Items
        Item sword = new Item("Mõõk", 10, 1, true, random, map);
        Item hammer = new Item("Haamer", 10, 1, true, random, map);
        Item boot = new Item("Tuhvel", 10, 1, true, random, map);

        // List<klass/prim klass> listiNimi = new ArrayList<>();
        // Listi saab panna ainult ühe klassi objekte
        List<Item> items = new ArrayList<>();
        items.add(sword);
        items.add(hammer);
        items.add(boot);

        // Esimene kuvamine
        map.printMap(characters, items);
        String input = scanner.nextLine();
        player.move(input, map);

        // Liikumisloogika
        while (!input.equals("end")) {
            map.printMap(characters, items);
            input = scanner.nextLine();
            player.move(input, map);
            for (Item e: items) {
                if (player.xCoord == e.xCoord &&  player.yCoord == e.yCoord) {
                    player.item = e;
                    // break loopist -> return tervest funktsioonist välja.
                    System.out.println("Korjasid eseme: " + e.name);
                    break;
                }
            }
        }
    } // main (args[])
} // Main ()