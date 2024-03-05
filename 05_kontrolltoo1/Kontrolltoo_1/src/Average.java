import java.util.ArrayList;
public class Average {
    // Arvutab kahe arvu ruutjuure
    public double sqrtProduct (double firstNum, double secondNum) {
        return Math.sqrt((firstNum * secondNum));
    }

    // Leiab mitme erineva arvu x astmes ruutjuure
    public double nthProduct (ArrayList<Double> numList){
        double product = 1.0;
        for (double num : numList){
            product *= num;
        }

        // Astmest ruutjuure tegemine käib murdarvude läbi ehk Math.pow(base, 1/2) on sama, mis Math.sqrt()
        return Math.pow(product, 1.0 / numList.size());
    }
}
