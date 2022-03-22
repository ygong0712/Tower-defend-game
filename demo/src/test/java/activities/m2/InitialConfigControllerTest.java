package activities.m2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InitialConfigControllerTest {

    // M2
    @Test
    void testValidName() {
        InitialConfigController controller = new InitialConfigController();
        String name = "test";
        assertEquals(controller.validInput(name), true);
    }

    // M2
    @Test
    void testEmptyName() {
        InitialConfigController controller = new InitialConfigController();
        String name = "";
        assertEquals(controller.validInput(name), false);
    }

    // M2
    @Test
    void testSpaceOnlyName() {
        InitialConfigController controller = new InitialConfigController();
        String name = "      ";
        assertEquals(controller.validInput(name), false);
    }

    // M2
    @Test
    void atLeastThreeLevels() {
        InitialConfigController controller = new InitialConfigController();
        assertEquals(controller.getDifficulties().length >= 3, true);
    }
}