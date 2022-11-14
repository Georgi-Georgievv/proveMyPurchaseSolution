package handlers;

import common.Message;
import common.Purchase;

public class President extends Approver {
    private static final String NAME = "President";

    @Override
    protected boolean canApprove(Purchase purchase) {
        double cost = purchase.cost();

        return switch (purchase.type()) {
            case CONSUMABLES -> cost <= 1000;
            case CLERICAL -> cost <= 2000;
            case GADGETS -> cost <= 3000;
            case GAMING -> cost <= 5000;
            case PC -> cost <= 8000;
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
