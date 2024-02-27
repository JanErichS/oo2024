import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("Kirjutatud.txt"));

        PrintWriter pw = new PrintWriter(new FileWriter("KirjutatudVeel.txt"));

        pw.println("Mina");
        pw.println("Olen");
        pw.println("Siin!");
        pw.print(" ");
        pw.println(" Yeaaah boyyy! Lightweight");
        pw.close();
        System.out.println("Fail sai loodud");

        bw.write("Ma olen siin \n");
        bw.write("Sa oled seal");
        bw.close();
    }
}