public class Info {
    String name;
    int ram;
    String gpu;

    public Info(String name, int ram, String gpu) {
        this.name = name;
        this.ram = ram;
        this.gpu = gpu;
    }

    public void changeName(String newName) {
        name = newName;
    }
}
