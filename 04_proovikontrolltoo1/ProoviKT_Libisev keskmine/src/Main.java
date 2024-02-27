//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
/*
** Koosta funktsioon kolme arvu aritmeetilise keskmise leidmiseks. Katseta.

 * Koosta funktsioon massiivi libiseva keskmise leidmiseks. Väljundiks on massiiv,
 * mis on sisendist kahe elemendi võrra lühem ning mille iga elemendi väärtuseks on sisendmassiivi vastava elemendi ning selle järgmise ja
 * ülejärgmise elemendi keskmine.

 * Koosta klass, mille eksemplarile saab vastava käsuga lisada arve.
 * Teise käsuga saab küsida nende arvude libiseva keskmise massiivi vastavalt eelmise punkti juhendile. Koosta kood nõnda,
 * et uue arvu lisamisel eksemplarile tehtaks uusi arvutusi võimalikult vähe (st. ei arvutataks kogu tulemust massiivi algusest uuesti)
* */


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        double threeAverage =  threeAvg(1, 2, 3);
        System.out.println(threeAverage);

        List<Double> numbers = new ArrayList<>();
        /*
        for (double i = 0; i < 12; i++) {
            numbers.add(i);
        } */

        numbers.add(4.0);
        numbers.add(7.0);
        numbers.add(8.0);

        System.out.println(numbers);

        List<Double> slidingAverage = slidingAvg(numbers);
        System.out.println("Siin kesmised: " + slidingAverage);


        Average average = new Average(numbers);
        List<Double> slidingAvg2 = average.getNewArr();
        System.out.println(slidingAvg2);
        average.addNum(10.0);

        List<Double> slidingAvg3 = average.getNewArr();
        System.out.println(slidingAvg3);

    } // Main end


    private static double threeAvg(double num1, double num2, double num3) {
        return (num1 + num2 + num3) / 3;
    }

    private static List<Double> slidingAvg(List<Double> numList) {
        List<Double> newArr = new ArrayList<>();

        // et saada 2 arvu vähem paned arvud.size() -2
        for (int i = 0; i < numList.size() - 2; i++) {
            double temp = numList.get(i) + numList.get(i + 1) + numList.get(i + 2);
            double avg = temp / 3;
            newArr.add(avg);
        }
        return newArr;
    }
}