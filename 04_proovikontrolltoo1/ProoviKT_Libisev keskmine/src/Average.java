/* Koosta klass, mille eksemplarile saab vastava käsuga lisada arve.
        * Teise käsuga saab küsida nende arvude libiseva keskmise massiivi vastavalt eelmise punkti juhendile. Koosta kood nõnda,
        * et uue arvu lisamisel eksemplarile tehtaks uusi arvutusi võimalikult vähe (st. ei arvutataks kogu tulemust massiivi algusest uuesti)
* */


import java.util.ArrayList;
import java.util.List;

public class Average {
    List<Double> numList = new ArrayList<>();
    List<Double> newArr = new ArrayList<>();

    public Average(List<Double> startNum) {
        numList = startNum;
        slidingAvg();
    }

    public void addNum(double newNum){
        newArr.add(newNum);
        Double last = newArr.get(newArr.size() - 1);
        Double secondLast = newArr.get(newArr.size() - 2);
        Double avg = (last + secondLast + newNum) / 3;
        newArr.add(avg);


    }

    public List<Double> getNewArr() {

        return newArr;
    }

    private List<Double> slidingAvg() {
        for (int i = 0; i < numList.size() - 2; i++) {
            double temp = numList.get(i) + numList.get(i + 1) + numList.get(i + 2);

            double avg = temp / 3;
            newArr.add(avg);
        }
        return newArr;
    }
}
