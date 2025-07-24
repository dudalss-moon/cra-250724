package mission2.service;

import mission2.domain.Car;
import mission2.service.factory.*;
import mission2.util.Util;
import mission2.util.validation.AnswerValidator;

import java.util.Scanner;

public class CarAssembler {
    private static final String CLEAR_SCREEN = "\033[H\033[2J";

    private Car car;
    private ProcessStep step;
    private RunTest carRunTest;

    private void init() {
        car = new Car();
        step = ProcessStep.CAR_TYPE;
        carRunTest = new RunTest();
    }

    public void assembleCar(Scanner sc) {
        init();

        processAssembleCar(step, sc);
    }

    private void processAssembleCar(ProcessStep step, Scanner sc) {
        while (true) {
            initializeBeforeStep();

            SelectProcessStepFactory.select(step);

            String buf = getAnswerAsStr(sc);

            if (isExitCondition(buf)) break;

            Integer answer = Util.getAnswerAsInt(buf);
            if (answer == null) continue;

            if (!AnswerValidator.isValidRange(step, answer)) {
                Util.delay(800);
                continue;
            }

            if (answer == 0) {
                movePreviousStep();
                continue;
            }

            processStepAndMoveNext(answer);
        }
    }

    private void processStepAndMoveNext(Integer answer) {
        switch (step) {
            case CAR_TYPE:
                car.setCarType(SelectCarTypeFactory.select(answer));
                delayAndMoveToStep(ProcessStep.ENGINE);
                break;
            case ENGINE:
                car.setEngine(SelectEngineFactory.select(answer));
                delayAndMoveToStep(ProcessStep.BRAKE_SYSTEM);
                break;
            case BRAKE_SYSTEM:
                car.setBrake(SelectBrakeFactory.select(answer));
                delayAndMoveToStep(ProcessStep.STEERING_SYSTEM);
                break;
            case STEERING_SYSTEM:
                car.setSteering(SelectSteeringFactory.select(answer));
                delayAndMoveToStep(ProcessStep.RUN_TEST);
                break;
            case RUN_TEST:
                carRunTest.processRunTest(car, answer);
                break;
        }
    }

    private void initializeBeforeStep() {
        System.out.print(CLEAR_SCREEN);
        System.out.flush();
    }

    private String getAnswerAsStr(Scanner sc) {
        System.out.print("INPUT > ");
        return sc.nextLine().trim();
    }

    private boolean isExitCondition(String buf) {
        if (buf.equalsIgnoreCase("exit")) {
            System.out.println("바이바이");
            return true;
        }
        return false;
    }

    private void delayAndMoveToStep(ProcessStep step) {
        Util.delay(800);
        this.step = step;
    }

    private void movePreviousStep() {
        switch (step) {
            case ENGINE -> {
                step = ProcessStep.CAR_TYPE;
            }
            case BRAKE_SYSTEM -> {
                step = ProcessStep.ENGINE;
            }
            case STEERING_SYSTEM -> {
                step = ProcessStep.BRAKE_SYSTEM;
            }
            case RUN_TEST -> {
                step = ProcessStep.CAR_TYPE;
            }
        }
    }
}