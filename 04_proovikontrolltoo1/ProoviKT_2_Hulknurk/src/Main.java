/* Koosta klass, milles on üks massiiv kolmnurga x-koordinaatide hoidmiseks ning teine massiiv y-koordinaatide hoidmiseks.
Koosta klassist kaks eksemplari, määra algväärtused ning trüki andmed välja.
* Lisa klassile käsklus punkti koordinaadipaari lisamiseks. Käsklusena väljasta tekkiva hulknurga ümbermõõt (küljepikkuste summa).
* Kuva tekkiv hulknurk graafiliselt, kirjuta külgede juurde nende pikkused ning hulknurga keskele kogu ümbermõõt. */

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> xCords = new ArrayList<>();
        xCords.add(3);
        xCords.add(6);
        xCords.add(9);

        List<Integer> yCords = new ArrayList<>();
        yCords.add(1);
        yCords.add(6);
        yCords.add(1);

        Triangle triangle = new Triangle(xCords, yCords);
        System.out.println(triangle.xCoords);
        System.out.println(triangle.yCoords);

        List<Double>dist = triangle.distance(xCords, yCords);
        System.out.println(dist);
    }
}