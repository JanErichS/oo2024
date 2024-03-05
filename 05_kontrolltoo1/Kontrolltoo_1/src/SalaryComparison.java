import java.io.*;
import java.util.ArrayList;

// Failis on viie aasta kohta koefitsiendid, kui palju igal aastal palk muutus (ise koosta testandmed). Samuti esimese aasta palk.
// Anna nii alg- kui ka lõppsumma klassi sees asuvatesse muutujatesse.
// Seejärel väljasta teise faili palk igal aastal neist ning võrdlusena kõrvale palk, kui palk oleks tõusnud iga aasta järel eelmistest koefitsentidest 2 korda kiiremini (kõik koefitsendid kahega korrutatult).
public class SalaryComparison {
    public SalaryComparison() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Palgad.txt"));
        double startingSalary;

        // Failist lugemine. Alguspalk
        String line = br.readLine();
        String[] temp = line.split(":");
        startingSalary = Integer.parseInt(temp[1]);

        // Falist lugemine. Koefitsendid
        ArrayList<Double> coefList = new ArrayList<>();
        br.readLine(); // Jätan rea vahele, sest siin on päis.
        while ((line = br.readLine()) != null){
            temp = line.split(",");
            coefList.add(Double.parseDouble(temp[1]));
        }
        br.close();

        // Palkade võrlduse loomine
        ArrayList<Double> salaryActual = new ArrayList<>();
        ArrayList<Double> salaryDouble = new ArrayList<>();

        // Kuna mul on koefitsendid antud 1.03 kujul, ehk 103% tõus, siis pean esmalt eemaldama "100%" ja seejärel saan alles kahekordistada.
        // Palgatõus on kumulatiivne, seetõttu pean esimese aasta tsüklist väljaspool tegema.
        salaryActual.add(startingSalary * coefList.get(0));
        salaryDouble.add(startingSalary * (1 + ((coefList.get(0) - 1)* 2)));

        for (int i = 1; i < coefList.size(); i++) {
            salaryActual.add(salaryActual.get(i - 1) * coefList.get(i));
            salaryDouble.add(salaryDouble.get(i - 1) * (1 + ((coefList.get(0) - 1)* 2)));
        }

        // Uue faili loomine
        PrintWriter pw = new PrintWriter(new FileWriter("Palgavõrdlus.txt"));

        // Päis ja algandmed
        pw.println("Aasta, Palk ; Topeltpalk");
        pw.println("0, " + startingSalary);

        for (int i = 0; i < salaryActual.size(); i++) {
            pw.println((i +1) + ", " + String.format("%.2f", salaryActual.get(i)) + "; " + String.format("%.2f", salaryDouble.get(i)));
        }
        pw.close();
    }
}
