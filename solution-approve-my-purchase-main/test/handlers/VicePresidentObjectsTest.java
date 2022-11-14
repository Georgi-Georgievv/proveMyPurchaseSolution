package handlers;

import common.Purchase;
import common.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VicePresidentObjectsTest {
    private VicePresident vicePresident;

    @BeforeEach
    public void init() {
        vicePresident = new VicePresident();
    }

    static List<Purchase> valid() {
        return List.of(
                new Purchase(1, 600, Type.CONSUMABLES),
                new Purchase(2, 1400, Type.CLERICAL),
                new Purchase(3, 1900, Type.GADGETS),
                new Purchase(4, 4400, Type.GAMING),
                new Purchase(5, 6400, Type.PC)
        );
    }

    static List<Purchase> validInclusive() {
        return List.of(
                new Purchase(1, 700, Type.CONSUMABLES),
                new Purchase(2, 1500, Type.CLERICAL),
                new Purchase(3, 2000, Type.GADGETS),
                new Purchase(4, 4500, Type.GAMING),
                new Purchase(5, 6500, Type.PC)
        );
    }

    static List<Purchase> invalid() {
        return List.of(
                new Purchase(1, 800, Type.CONSUMABLES),
                new Purchase(2, 1600, Type.CLERICAL),
                new Purchase(3, 2100, Type.GADGETS),
                new Purchase(4, 4600, Type.GAMING),
                new Purchase(5, 6600, Type.PC)
        );
    }

    @ParameterizedTest
    @MethodSource("valid")
    void givenVicePresident_whenInApproveLimit_thenTrue(Purchase purchase) {
        System.out.println("Testing Vice President valid purchase id: " + purchase.id());

        testTrue(purchase);
    }

    @ParameterizedTest
    @MethodSource("validInclusive")
    void givenVicePresident_whenInclusive_returnsTrue(Purchase purchase) {
        System.out.println("Testing Vice President inclusive purchase id: " + purchase.id());

        testTrue(purchase);
    }

    private void testTrue(Purchase purchase) {
        boolean actual = vicePresident.canApprove(purchase);

        assertTrue(actual);
    }

    @ParameterizedTest
    @MethodSource("invalid")
    void givenVicePresident_whenOverLimit_returnsFalse(Purchase invalid) {
        System.out.println("Testing Vice President invalid purchase id: " + invalid.id());

        boolean actual = vicePresident.canApprove(invalid);

        assertFalse(actual);
    }
}
