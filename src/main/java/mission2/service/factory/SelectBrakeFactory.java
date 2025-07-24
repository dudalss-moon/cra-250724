package mission2.service.factory;

import mission2.domain.parts.Brake;

public class SelectBrakeFactory {
    private static final int MANDO = 1, CONTINENTAL = 2, BOSCH_B = 3;

    public static Brake select(int type) {
        printSelectBrakeSystem(type);

        return switch (type) {
            case MANDO -> Brake.MANDO;
            case CONTINENTAL -> Brake.CONTINENTAL;
            case BOSCH_B -> Brake.BOSCH_B;
            default -> Brake.NONE;
        };
    }

    private static void printSelectBrakeSystem(int a) {
        String name = a == 1 ? "MANDO" : a == 2 ? "CONTINENTAL" : "BOSCH";
        System.out.printf("%s 제동장치를 선택하셨습니다.\n", name);
    }
}
