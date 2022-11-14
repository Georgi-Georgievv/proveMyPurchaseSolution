package common;

public class Message {

    private Message() {
        throw new IllegalStateException("Utility class");
    }

    public static void approved(String approver, int order, double cost) {
        String text = String.format("%s approved purchase %d that cost %.2f.", approver, order, cost);
        System.out.println(text);
    }

    public static void error(int order, double cost) {
        String text = String.format("Purchase %d that costs %.2f requires an executive meeting in order" +
                " to be approved", order, cost);
        System.out.println(text);
    }
}
