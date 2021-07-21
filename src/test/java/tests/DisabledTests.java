package tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DisabledTests {
    @Test
    @Disabled ("disabled for test")
    void someTest() {
        assertTrue(false);
    }
    @Test
    @Disabled ("disabled for test")
    void some1Test() {
        assertTrue(false);
    }

    @Test
    @Disabled ("disabled for test")
    void some2Test() {
        assertTrue(false);
    }

    @Test
    @Disabled ("disabled for test")
    void some3Test() {
        assertTrue(false);
    }

    @Test
    @Disabled ("disabled for test")
    void some4Test() {
        assertTrue(false);
    }

    @Test
    @Disabled ("disabled for test")
    void some5Test() {
        assertTrue(false);
    }
}
