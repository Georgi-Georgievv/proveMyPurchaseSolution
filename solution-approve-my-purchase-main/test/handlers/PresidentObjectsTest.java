package handlers;

import common.Purchase;
import common.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PresidentObjectsTest {
    private President president;

    @BeforeEach
    public void init() {
        president = new President();
    }

    static List<Purchase> valid() {
        return List.of(
                new Purchase(1, 900, Type.CONSUMABLES),
                new Purchase(2, 1900, Type.CLERICAL),
                new Purchase(3, 2900, Type.GADGETS),
                new Purchase(4, 4900, Type.GAMING),
                new Purchase(5, 7900, Type.PC)
        );
    }

    static List<Purchase> validInclusive() {
        return List.of(
                new Purchase(1, 1000, Type.CONSUMABLES),
                new Purchase(2, 2000, Type.CLERICAL),
                new Purchase(3, 3000, Type.GADGETS),
                new Purchase(4, 5000, Type.GAMING),
                new Purchase(5, 8000, Type.PC)
        );
    }

    static List<Purchase> invalid() {
        return List.of(
                new Purchase(1, 1100, Type.CONSUMABLES),
                new Purchase(2, 2100, Type.CLERICAL),
                new Purchase(3, 3100, Type.GADGETS),
                new Purchase(4, 5100, Type.GAMING),
                new Purchase(5, 8100, Type.PC)
        );
    }

    @ParameterizedTest
    @MethodSource("valid")
    void givenPresident_whenInApproveLimit_thenTrue(Purchase purchase) {
        System.out.println("Testing President valid purchase id: " + purchase.id());

        testTrue(purchase);
    }

    @ParameterizedTest
    @MethodSource("validInclusive")
    void givenPresident_whenInclusive_returnsTrue(Purchase purchase) {
        System.out.println("Testing President inclusive purchase id: " + purchase.id());

        testTrue(purchase);
    }

    private void testTrue(Purchase purchase) {
        boolean actual = president.canApprove(purchase);

        assertTrue(actual);
    }

    @ParameterizedTest
    @MethodSource("invalid")
    void givenPresident_whenOverLimit_returnsFalse(Purchase invalid) {
        System.out.println("Testing President invalid purchase id: " + invalid.id());

        boolean actual = president.canApprove(invalid);

        assertFalse(actual);
    }
}
