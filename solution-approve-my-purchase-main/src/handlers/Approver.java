package handlers;

import common.Purchase;

public abstract class Approver {

    protected Approver next;

    protected abstract boolean canApprove(Purchase purchase);
    public abstract void approve(Purchase purchase);


    public Approver registerNext(Approver next) {
        this.next = next;
        return this.next;
    }
}
