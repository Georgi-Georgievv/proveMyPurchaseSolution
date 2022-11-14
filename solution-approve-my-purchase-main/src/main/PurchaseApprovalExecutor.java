package main;

import common.Purchase;
import common.Type;
import handlers.Approver;
import handlers.Manager;

public class PurchaseApprovalExecutor {

    private PurchaseApprovalExecutor() {
        throw new IllegalStateException();
    }

    public static void execute() {
        Approver manager = new Manager();
        ApprovalChainGenerator.generate(manager);

        var managerPurchase = new Purchase(1, 200, Type.CONSUMABLES);
        var directorPurchase = new Purchase(2, 5500, Type.PC);
        var vicePresidentPurchase = new Purchase(3, 2000, Type.GADGETS);
        var presidentPurchase = new Purchase(4, 2000, Type.CLERICAL);
        var executiveMeetingPurchase = new Purchase(5, 6000, Type.GAMING);

        manager.approve(managerPurchase);
        manager.approve(directorPurchase);
        manager.approve(vicePresidentPurchase);
        manager.approve(presidentPurchase);
        manager.approve(executiveMeetingPurchase);
    }
}
