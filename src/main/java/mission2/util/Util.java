package mission2.util;

public class Util {
    public static void delay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {}
    }

    public static Integer getAnswerAsInt(String buf) {
        int answer;
        try {
            answer = Integer.parseInt(buf);
        } catch (NumberFormatException e) {
            System.out.println("ERROR :: 숫자만 입력 가능");
            Util.delay(800);
            return null;
        }
        return answer;
    }
}
