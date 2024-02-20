public class Computer {
    Info info; // Klassikomplekt (Seda ongi vaja)
    double price;
    String store;

    public Computer(Info info, int price, String store) {
        this.info = info;
        this.price = price;
        this.store = store;
    }

    public void changePrice(double amount) {
        price = price + amount;
    }
}
