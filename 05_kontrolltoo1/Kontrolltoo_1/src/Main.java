import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        /* Geomeetriline keskmine
        * Koosta klass ja tema sisse funktsioon, mis korrutab parameetritena antud kaks arvu ning võtab neist ruutjuure (Math.sqrt). Katseta.
        * Koosta klassi sisse teine funktsioon, kuhu võib arve rohkem sisestada, need antakse ette kogumina. Arvud korrutatakse kokku ning võetakse niimitmes juur (astendaja pöördväärtus, Math.pow), kuimitu arvu oli.
        * Failis on viie aasta kohta koefitsiendid, kui palju igal aastal palk muutus (ise koosta testandmed). Samuti esimese aasta palk.
        * Anna nii alg- kui ka lõppsumma klassi sees asuvatesse muutujatesse. Seejärel väljasta teise faili palk igal aastal neist ning võrdlusena kõrvale palk,
        * kui palk oleks tõusnud iga aasta järel eelmistest koefitsentidest 2 korda kiiremini (kõik koefitsendid kahega korrutatult).
        */

        double firstNum = 4.0;
        double secondNum = 8.0;

        Average average = new Average();
        new SalaryComparison();

        double squareRoot = average.sqrtProduct(firstNum, secondNum);
        System.out.println("Kahe erineva arvu ruutjuur: " + squareRoot);

        ArrayList<Double> numList = new ArrayList<>();

        numList.add(3.0);
        numList.add(4.0);
        numList.add(5.0);

        double nthSquareRoot = average.nthProduct(numList);
        System.out.println("x arvu juur: " + nthSquareRoot);
    }
}