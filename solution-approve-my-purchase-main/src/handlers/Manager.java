package handlers;

import common.Message;
import common.Purchase;

public class Manager extends Approver {
    private static final String NAME = "Manager";

    @Override
    protected boolean canApprove(Purchase purchase) {
        double cost = purchase.cost();

        return switch (purchase.type()) {
            case CONSUMABLES -> cost <= 300;
            case CLERICAL -> cost <= 500;
            case GADGETS -> cost <= 1000;
            case GAMING -> cost <= 3000;
            case PC -> cost <= 5000;
        };
    }

    @Override
    public void approve(Purchase purchase) {
        if (canApprove(purchase)) {
            Message.approved(NAME, purchase.id(), purchase.cost());
            return;
        }

        System.out.println("Purchase with id " + purchase.id() + " needs approval from higher position than " + NAME);
        next.approve(purchase);
    }
}
