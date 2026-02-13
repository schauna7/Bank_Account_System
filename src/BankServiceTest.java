import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankServiceTest {

    @Test
    void testCreateAccount() {
        BankService bankService = new BankService();
        BankAccount account = bankService.createAccount("Preeti", 1000.0);

        assertNotNull(account);
        assertEquals("Preeti", account.getAccountHolderName());
        assertEquals(1000.0, account.getBalance());
        assertNotNull(account.getAccountNumber());
    }

    @Test
    void testFindAccount() {
        BankService bankService = new BankService();
        BankAccount account = bankService.createAccount("John", 500.0);

        BankAccount found = bankService.findAccount(account.getAccountNumber());

        assertNotNull(found);
        assertEquals("John", found.getAccountHolderName());
    }

    @Test
    void testFindAccountNotFound() {
        BankService bankService = new BankService();

        BankAccount result = bankService.findAccount("1234567890");

        assertNull(result);
    }
}
