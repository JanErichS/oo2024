//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Info info = new Info("Big boy", 256, "Club X");
        Computer computer = new Computer(info, 19999, "Pood");

        Computer computer1 = new Computer(new Info("Bigger boy", 512, "Club Y"), 1999999, "Pood2");
        computer.changePrice(300000000);

        computer.info.changeName("smollerBoy");
    }
}