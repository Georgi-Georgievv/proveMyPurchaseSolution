package main;

public class Main {

    public static class Executor {

        public void execute() {
            PurchaseApprovalExecutor.execute();
        }
    }

    public static void main(String[] args) {
        Executor e = new Executor();
        e.execute();
    }

}
