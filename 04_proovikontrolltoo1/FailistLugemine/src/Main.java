import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

// Fail peab olema src kasutast üks aste kõrgemal
// Ja avatud tohib olla ainult selle projekti kaust
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("lugemine.txt"));

        String line = br.readLine();
        while (line != null){
            System.out.println(line);
            String[] words = line.split(" ");
            System.out.println(Arrays.toString(words));
            line = br.readLine();

            double power = Math.pow(words.length, 2);
            System.out.println(power);

            double squareRT = Math.sqrt(words.length);
            System.out.println(squareRT);
        }
    }
}