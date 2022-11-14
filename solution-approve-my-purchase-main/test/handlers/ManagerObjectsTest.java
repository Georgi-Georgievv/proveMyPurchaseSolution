package handlers;

import common.Purchase;
import common.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ManagerObjectsTest {

    private Manager manager;

    @BeforeEach
    public void init() {
        manager = new Manager();
    }

    static List<Purchase> valid() {
        return List.of(
                new Purchase(1, 200, Type.CONSUMABLES),
                new Purchase(2, 400, Type.CLERICAL),
                new Purchase(3, 900, Type.GADGETS),
                new Purchase(4, 2900, Type.GAMING),
                new Purchase(5, 4900, Type.PC)
        );
    }

    static List<Purchase> validInclusive() {
        return List.of(
                new Purchase(1, 300, Type.CONSUMABLES),
                new Purchase(2, 500, Type.CLERICAL),
                new Purchase(3, 1000, Type.GADGETS),
                new Purchase(4, 3000, Type.GAMING),
                new Purchase(5, 5000, Type.PC)
        );
    }

    static List<Purchase> invalid() {
        return List.of(
                new Purchase(1, 500, Type.CONSUMABLES),
                new Purchase(2, 1000, Type.CLERICAL),
                new Purchase(3, 1500, Type.GADGETS),
                new Purchase(4, 4000, Type.GAMING),
                new Purchase(5, 6000, Type.PC)
        );
    }

    @ParameterizedTest
    @MethodSource("valid")
    void givenManager_whenInApproveLimit_thenTrue(Purchase purchase) {
        System.out.println("Testing Manager valid purchase id: " + purchase.id());

        testTrue(purchase);
    }

    @ParameterizedTest
    @MethodSource("validInclusive")
    void givenManager_whenInclusive_returnsTrue(Purchase purchase) {
        System.out.println("Testing Manager valid inclusive purchase id: " + purchase.id());

        testTrue(purchase);
    }

    private void testTrue(Purchase purchase) {
        boolean actual = manager.canApprove(purchase);

        assertTrue(actual);
    }

    @ParameterizedTest
    @MethodSource("invalid")
    void givenManager_whenOverLimit_returnsFalse(Purchase invalid) {
        System.out.println("Testing Manager invalid purchase id: " + invalid.id());

        boolean actual = manager.canApprove(invalid);

        assertFalse(actual);
    }
}
