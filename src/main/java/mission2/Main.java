package mission2;

import mission2.domain.Car;
import mission2.service.CarAssembler;
import mission2.service.RunTest;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        RunTest runTest = new RunTest();
        Scanner sc = new Scanner(System.in);

        CarAssembler assemble = new CarAssembler(car, runTest, sc);
        assemble.assembleCar();
    }
}
