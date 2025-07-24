package mission2.factory;

import mission2.parts.Steering;

public class SelectSteeringFactory {
    private static final int BOSCH_S = 1, MOBIS = 2;

    public static Steering select(int type) {
        printSelectSteeringSystem(type);

        return switch (type) {
            case BOSCH_S -> Steering.BOSCH;
            case MOBIS -> Steering.MOBIS;
            default -> Steering.NONE;
        };
    }

    private static void printSelectSteeringSystem(int a) {
        String name = a == 1 ? "BOSCH" : "MOBIS";
        System.out.printf("%s 조향장치를 선택하셨습니다.\n", name);
    }
}
