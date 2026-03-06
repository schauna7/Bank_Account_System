package tutorial;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AppTest 
{
    @Test
    public void testAddition()
    {
        int result = App.add(5, 7);
        assertEquals(12, result);
    }
}