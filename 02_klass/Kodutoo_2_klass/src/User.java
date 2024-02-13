public class User {
    // Right click -> Generate -> Constructor
    public User(String name, boolean active, int age, char abbr, double balance) {
        this.name = name;
        this.active = active;
        this.age = age;
        this.abbr = abbr;
        this.balance = balance;
    }

    // Kas ainult siin failis, vaste, nimi
    public void changeActive() {
        active = !active;
    }

    public double addBal(double amount) {
        balance = balance + amount;
        return balance;
    }
    String name;
    boolean active;
    int age;
    char abbr;
    double balance;
}
