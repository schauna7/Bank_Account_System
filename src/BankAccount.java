import java.util.Random;

public class BankAccount {

    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // Constructor generates random 10-digit account number automatically
    public BankAccount(String accountHolderName, double balance) {
        this.accountNumber = generateAccountNumber();
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // Generate a random 10-digit account number
    private String generateAccountNumber() {
        Random random = new Random();
        StringBuilder accNum = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            accNum.append(random.nextInt(10));
        }
        return accNum.toString();
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {   
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Deposit must be positive.");
        balance += amount;
    }

    // Withdraw money
    public void withdraw(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Withdrawal must be positive.");
        if (amount > balance)
            throw new IllegalArgumentException("Insufficient balance.");
        balance -= amount;
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: $" + balance);
    }
}
