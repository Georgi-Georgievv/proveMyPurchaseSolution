package handlers;

import common.Purchase;
import common.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DirectorObjectsTest {

    private Director director;

    @BeforeEach
    public void init() {
        director = new Director();
    }

    static List<Purchase> valid() {
        return List.of(
                new Purchase(1, 400, Type.CONSUMABLES),
                new Purchase(2, 900, Type.CLERICAL),
                new Purchase(3, 1500, Type.GADGETS),
                new Purchase(4, 3400, Type.GAMING),
                new Purchase(5, 5900, Type.PC)
        );
    }

    static List<Purchase> validInclusive() {
        return List.of(
                new Purchase(1, 500, Type.CONSUMABLES),
                new Purchase(2, 1000, Type.CLERICAL),
                new Purchase(3, 1500, Type.GADGETS),
                new Purchase(4, 3500, Type.GAMING),
                new Purchase(5, 6000, Type.PC)
        );
    }

    static List<Purchase> invalid() {
        return List.of(
                new Purchase(1, 600, Type.CONSUMABLES),
                new Purchase(2, 1100, Type.CLERICAL),
                new Purchase(3, 1600, Type.GADGETS),
                new Purchase(4, 3600, Type.GAMING),
                new Purchase(5, 6100, Type.PC)
        );
    }

    @ParameterizedTest
    @MethodSource("valid")
    void givenDirector_whenInApproveLimit_thenTrue(Purchase purchase) {
        System.out.println("Testing Director valid purchase id: " + purchase.id());

        testTrue(purchase);
    }

    @ParameterizedTest
    @MethodSource("validInclusive")
    void givenDirector_whenInclusive_returnsTrue(Purchase purchase) {
        System.out.println("Testing Director inclusive purchase id: " + purchase.id());

        testTrue(purchase);
    }

    private void testTrue(Purchase purchase) {
        boolean actual = director.canApprove(purchase);

        assertTrue(actual);
    }

    @ParameterizedTest
    @MethodSource("invalid")
    void givenDirector_whenOverLimit_returnsFalse(Purchase purchase) {
        System.out.println("Testing Director invalid purchase id: " + purchase.id());

        boolean actual = director.canApprove(purchase);

        assertFalse(actual);
    }
}
