import org.junit.*;
import java.util.Random;

public class addTest {

    @Test
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
    }
}
