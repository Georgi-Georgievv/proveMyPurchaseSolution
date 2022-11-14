package main;

import handlers.*;

public class ApprovalChainGenerator {

    private ApprovalChainGenerator() {
        throw new IllegalStateException();
    }

    public static void generate(Approver manager) {
        Approver director = new Director();
        Approver vicePresident = new VicePresident();
        Approver president = new President();

        manager
                .registerNext(director)
                .registerNext(vicePresident)
                .registerNext(president)
                .registerNext(ExecutiveMeeting.getInstance());
    }
}
