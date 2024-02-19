//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        User user = new User("Peeter", true, 123, 'P', 5.21);
//        User user2 = new User("Pietrina", true, 0, 'B', 3.24);
//
//        user.changeActive();
//        user2.addBal(3);

        // Kodus tehtud osa
        int b1, b2;
        double r1late, r2late;

        Book book = new Book("Mina ja nemad", 1, 200, "Peeter Paan", "Raamatukogu1", 3);
        Book book2 = new Book("Nemad teavad", 2, 250, "Matilda Madis", "Raamatukogu1", 2);

        b1 = book.loanBook(3);
        System.out.println("Raamatut1 on: " + b1);
        b2 = book2.loanBook(0);
        System.out.println("Raamatut2 on: " + b2);

        Reader reader = new Reader("Matilda", "Mari", 15, 1, false, 0);
        Reader reader1 = new Reader("Mati", "Meelis", 30, 2, true, 0);

        r1late = reader.findLateFee(15, false);
        System.out.println("Viivis on: " + r1late);
        r2late = reader1.findLateFee(30, true);
        System.out.println("Viivis on: " + r2late);


    }
} // Main end