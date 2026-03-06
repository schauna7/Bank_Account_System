import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    void testDeposit() {
        BankAccount account = new BankAccount("John", 1000);
        account.deposit(500);
        assertEquals(1500, account.getBalance());
    }

    @Test
    void testWithdraw() {
        BankAccount account = new BankAccount("John", 1000);
        account.withdraw(300);
        assertEquals(700, account.getBalance());
    }

    @Test
    void testWithdrawInsufficientBalance() {
        BankAccount account = new BankAccount("John", 1000);
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(2000);
        });
    }
}
