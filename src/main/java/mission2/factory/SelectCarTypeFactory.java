package mission2.factory;

import mission2.CarType;

public class SelectCarTypeFactory {

    private static final int SEDAN = 1, SUV = 2, TRUCK = 3;

    public static CarType select(int type) {
        printSelectCarType(type);
        return switch (type) {
            case SEDAN -> CarType.SEDAN;
            case SUV -> CarType.SUV;
            case TRUCK -> CarType.TRUCK;
            default -> CarType.NONE;
        };
    }

    private static void printSelectCarType(int a) {
        System.out.printf("차량 타입으로 %s을 선택하셨습니다.\n", a == 1 ? "Sedan" : a == 2 ? "SUV" : "Truck");
    }
}
