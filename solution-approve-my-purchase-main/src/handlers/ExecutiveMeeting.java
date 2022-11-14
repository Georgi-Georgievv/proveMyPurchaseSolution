package handlers;

import common.Message;
import common.Purchase;

/**
 * Used as fallback in approval chain, if it is out of the limits
 * of given managers.
 */
public class ExecutiveMeeting extends Approver {
    private static final ExecutiveMeeting INSTANCE = new ExecutiveMeeting();

    public static ExecutiveMeeting getInstance() {
        return INSTANCE;
    }

    @Override
    public void approve(Purchase purchase) {
        Message.error(purchase.id(), purchase.cost()
        );
    }

    @Override
    protected boolean canApprove(Purchase purchase) {
        return false;
    }
}
