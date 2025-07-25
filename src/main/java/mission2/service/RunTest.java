package mission2.service;

import mission2.domain.Car;
import mission2.domain.CarType;
import mission2.domain.parts.Brake;
import mission2.domain.parts.Engine;
import mission2.domain.parts.Steering;

import static mission2.util.Util.delay;

public class RunTest {

    public void runTest(Car car, Integer answer) {
        if (answer == 1) {
            runProducedCar(car);
            delay(2000);
        } else if (answer == 2) {
            System.out.println("Test...");
            delay(1500);
            testProducedCar(car);
            delay(2000);
        }
    }
    private void runProducedCar(Car car) {
        if (!isValidCheck(car)) {
            System.out.println("자동차가 동작되지 않습니다");
            return;
        }
        if (car.isEngineBroken()) {
            System.out.println("엔진이 고장나있습니다.");
            System.out.println("자동차가 움직이지 않습니다.");
            return;
        }

        System.out.printf("Car Type : %s\n", car.getCarType());
        System.out.printf("Engine   : %s\n", car.getEngine().name());
        System.out.printf("Brake    : %s\n", car.getBrake());
        System.out.printf("Steering : %s\n", car.getSteering());
        System.out.println("자동차가 동작됩니다.");
    }

    private void testProducedCar(Car car) {
        if(car.getCarType() == CarType.SEDAN && car.getBrake() == Brake.CONTINENTAL) {
            fail("Sedan에는 Continental제동장치 사용 불가");
        } else if(car.getCarType() == CarType.SUV && car.getEngine() == Engine.TOYOTA) {
            fail("SUV에는 TOYOTA엔진 사용 불가");
        } else if(car.getCarType() == CarType.TRUCK && car.getEngine() == Engine.WIA) {
            fail("Truck에는 WIA엔진 사용 불가");
        } else if(car.getCarType() == CarType.TRUCK && car.getBrake() == Brake.MANDO) {
            fail("Truck에는 Mando제동장치 사용 불가");
        } else if(car.getBrake() == Brake.BOSCH_B && car.getSteering() == Steering.BOSCH) {
            fail("Bosch제동장치에는 Bosch조향장치 이외 사용 불가");
        } else {
            System.out.println("자동차 부품 조합 테스트 결과 : PASS");
        }
    }

    private boolean isValidCheck(Car car) {
        if (car.getCarType() == CarType.SEDAN && car.getBrake() == Brake.CONTINENTAL) return false;
        if (car.getCarType() == CarType.SUV && car.getEngine() == Engine.TOYOTA) return false;
        if (car.getCarType() == CarType.TRUCK && car.getEngine() == Engine.WIA) return false;
        if (car.getCarType() == CarType.TRUCK && car.getBrake() == Brake.MANDO) return false;
        if (car.getBrake() == Brake.BOSCH_B && car.getSteering() == Steering.BOSCH) return false;
        return true;
    }

    private void fail(String msg) {
        System.out.println("자동차 부품 조합 테스트 결과 : FAIL");
        System.out.println(msg);
    }
}
