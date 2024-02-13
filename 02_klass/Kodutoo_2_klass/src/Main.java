//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        User user = new User("Peeter", true, 123, 'P', 5.21);
        User user2 = new User("Pietrina", true, 0, 'B', 3.24);

        user.changeActive();
        user2.addBal(3);
    }
}