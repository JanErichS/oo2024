public class Main {
    public static void main(String[] args) {
        // Temperatuuride konverteerimine
        double temperature = 32;
        double FtoC = tempConversion(temperature, 'f');
        double CtoF = tempConversion(temperature, 'C');

        System.out.println(temperature  + " F on " + FtoC + " C");
        System.out.println(temperature  + " C on " + CtoF + " F");

        temperature = 98.6;
        FtoC = tempConversion(temperature, 'f');
        CtoF = tempConversion(temperature, 'C');
        System.out.println(temperature  + " F on " + FtoC + " C");
        System.out.println(temperature  + " C on " + CtoF + " F");

        // Stringi tagurpidi keeramine
        String someString = "Mingi tekst";
        String reversedString = backString(someString);
        System.out.println("Lause \"" + someString + "\"\n tagurpidi on: \"" + reversedString + "\"");

        someString = "Mingiveelpikem tekst vist";
        reversedString = backString(someString);
        System.out.println("Lause \"" + someString + "\"\n tagurpidi on: \"" + reversedString + "\"");

        // Massiivi arvude summeerimine
        int[] bigArr = {1,2,3,4,5,6,7,8,9,10,132,124,435};
        int arrSum = arraySum(bigArr);
        System.out.printf("Massiivi summa on: %d", arrSum);
    }

    private static Double tempConversion(double temp, char convTo) {
        // F->C  => ((F-32)*5)9
        // C->F => (C * 9 / 5) + 32
        convTo = Character.toLowerCase(convTo);
        if (convTo == 'c'){
            return (temp * 9 / 5) + 32;
        } else if (convTo == 'f') {
            return ((temp - 32) * 5) / 9;
        } else {
            return null;
        }
    }

    private static String backString(String initString) {
        int strLen = initString.length();
        StringBuilder reverseStr = new StringBuilder();
        for (int i = strLen - 1 ; i >= 0; i--) {
            char tempChar = initString.charAt(i);
            reverseStr.append(tempChar);
        }
        return reverseStr.toString();
    }

    private static int arraySum(int[] array) {
        int finalSum = 0;
        for (int i = 0; i < array.length; i++){
            finalSum += array[i];
        }
        return finalSum;
    }

}