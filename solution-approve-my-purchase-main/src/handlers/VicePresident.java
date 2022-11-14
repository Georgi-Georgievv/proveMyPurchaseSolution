package handlers;

import common.Message;
import common.Purchase;

public class VicePresident extends Approver {
    private static final String NAME = "Vice President";

    @Override
    protected boolean canApprove(Purchase purchase) {
        double cost = purchase.cost();

        return switch (purchase.type()) {
            case CONSUMABLES -> cost <= 700;
            case CLERICAL -> cost <= 1500;
            case GADGETS -> cost <= 2000;
            case GAMING -> cost <= 4500;
            case PC -> cost <= 6500;
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
