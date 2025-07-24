package mission2.service.factory;

import mission2.domain.parts.Engine;

public class SelectEngineFactory {
    private static final int GM = 1, TOYOTA = 2, WIA = 3, BROKEN = 4;

    public static Engine select(int type) {
        printSelectEngine(type);

        return switch (type) {
            case GM -> Engine.GM;
            case TOYOTA -> Engine.TOYOTA;
            case WIA -> Engine.WIA;
            case BROKEN -> Engine.BROKEN;
            default -> Engine.NONE;
        };
    }

    private static void printSelectEngine(int a) {
        String name = a == 1 ? "GM" : a == 2 ? "TOYOTA" : a == 3 ? "WIA" : "고장난 엔진";
        System.out.printf("%s 엔진을 선택하셨습니다.\n", name);
    }
}
