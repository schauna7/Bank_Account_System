import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Assertions;

import java.util.Random;

public class addTest {

    @Test
    void fixedValueTest() {
        add add_var = new add();

        Assertions.assertEquals(-7, add_var.addNumbers(-4, -3));
        Assertions.assertEquals(90, add_var.addNumbers(80, 10));
        Assertions.assertEquals(1, add_var.addNumbers(1, 0));
        Assertions.assertEquals(11, add_var.addNumbers(1, 10));
    }

    @RepeatedTest(50)
    void randomAdditionTest() {
        add add_var = new add();
        Random random = new Random();

        int x = random.nextInt(1000) - 500;
        int y = random.nextInt(1000) - 500;

        int expected = Math.addExact(x, y);
        int actual = add_var.addNumbers(x, y);

        Assertions.assertEquals(
                expected,
                actual,
                "Failed for x=" + x + ", y=" + y
        );
    }
}
