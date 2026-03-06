package tutorial;
import java.util.ArrayList;
import java.util.List;

public class BankService {

    // List to store all accounts
    private List<BankAccount> accounts;

    // Constructor
    public BankService() {
        accounts = new ArrayList<>();
    }

    // Create a new account (account number is generated automatically in BankAccount)
    public BankAccount createAccount(String accountHolderName, double initialBalance) {
        BankAccount newAccount = new BankAccount(accountHolderName, initialBalance);

        // Ensure account number is unique (unlikely to collide, but just in case)
        while (findAccount(newAccount.getAccountNumber()) != null) {
            newAccount = new BankAccount(accountHolderName, initialBalance);
        }

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
