//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // 3 Funktiooni, milles kasutatud min 4 erinevat andmetüüpi
        // ei pea olema kõik erinevad sisendid/väljundid
        //  nt int -> double, int -> float tehniliselt sobiks
        // double komakohaga arv, tihti kasutatud, vähemtäpsem, kui float
        // Teha igast funktsioonist 2 erineva sisendga väljakutset
        double kogumkse = autuHind(3);
        System.out.println(kogumkse);

        double kogumakse1 = autuHind(4);
        System.out.println(kogumakse1);

        String temp1 = tempCheck(3);
        System.out.println(temp1);
    }
    // Näiteks
    private static double autuHind(int tunnid) {
        return 3 + 0.9*tunnid;
    }

    private static String tempCheck(double temp) {
        if (temp < 0){
            return "Ice";
        } else {
            return "no ice";
        }
    }
}