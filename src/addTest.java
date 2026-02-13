<<<<<<< HEAD
import org.junit.*;
=======
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Assertions;

>>>>>>> 78f5310b0be8820ae1cd40753f02a13e4a4e4a1c
import java.util.Random;

public class addTest {

    @Test
<<<<<<< HEAD
    public void testRandomAdd() {
        Random rand = new Random();
        add add_var = new add();

        for (int i = 0; i < 6; i++) {
            int a = rand.nextInt(101); // 0 to 100
            int b = rand.nextInt(101);

            int expectedSum = a + b;
            int actualSum = add_var.addNumbers(a, b);
            //correct sum
            Assert.assertEquals(expectedSum, actualSum);
            //wrong sum
            int wrongSum = expectedSum + 1; // simple wrong value
            Assert.assertNotEquals(wrongSum, actualSum);
            // making sure object exists
            Assert.assertNotNull(add_var);
            // print the values
            System.out.println("Test " + (i+1) + ": " + a + " + " + b + " = " + actualSum);
        }
=======
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
>>>>>>> 78f5310b0be8820ae1cd40753f02a13e4a4e4a1c
    }
}
