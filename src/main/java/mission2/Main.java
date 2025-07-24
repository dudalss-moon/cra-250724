package mission2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AssembleCar assemble = new AssembleCar();
        Scanner sc = new Scanner(System.in);
        assemble.assembleCar(sc);
        sc.close();
    }
}
