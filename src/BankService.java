import java.util.ArrayList;
import java.util.List;

public class BankService {

    // List to store all accounts
    private List<BankAccount> accounts;

    // Constructor
    public BankService() {
        accounts = new ArrayList<>();
    }

    // Create a new account
    public BankAccount createAccount(String accountNumber, String accountHolderName, double initialBalance) {
        // Check if account number already exists
        if (findAccount(accountNumber) != null) {
            throw new IllegalArgumentException("Account number already exists.");
        }

        // Create new BankAccount
        BankAccount newAccount = new BankAccount(accountNumber, accountHolderName, initialBalance);
        accounts.add(newAccount);
        return newAccount;
    }

    // Find account by account number
    public BankAccount findAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null; // Not found
    }

    // Display all accounts
    public void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
            return;
        }

        for (BankAccount account : accounts) {
            account.displayAccountInfo();
            System.out.println("-------------------------");
        }
    }
}
