package mission2;

import mission2.service.CarAssembler;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CarAssembler assemble = new CarAssembler();
        Scanner sc = new Scanner(System.in);
        assemble.assembleCar(sc);
        sc.close();
    }
}
