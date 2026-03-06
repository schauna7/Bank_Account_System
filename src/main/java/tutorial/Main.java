package tutorial;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankService bankService = new BankService();

        System.out.println("Welcome to the Bank Account System!");

        boolean running = true;

        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Create a new account");
            System.out.println("2. Display all accounts");
            System.out.println("3. Deposit money");
            System.out.println("4. Withdraw money");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
    System.out.print("Enter account holder name: ");
    String accHolder = scanner.nextLine();
    System.out.print("Enter initial balance: ");
    double balance = scanner.nextDouble();
    scanner.nextLine(); // consume newline

    try {
        BankAccount newAccount = bankService.createAccount(accHolder, balance);
        System.out.println("Account created successfully!");
        System.out.println("Your account number is: " + newAccount.getAccountNumber());
    } catch (IllegalArgumentException e) {
        System.out.println("Error: " + e.getMessage());
    }
    break;


                case 2:
                    bankService.displayAllAccounts();
                    break;

                case 3:
                    System.out.print("Enter account number to deposit into: ");
                    String depositAcc = scanner.nextLine();
                    System.out.print("Enter amount to deposit: ");
                    double depositAmt = scanner.nextDouble();
                    scanner.nextLine();

                    BankAccount depAccount = bankService.findAccount(depositAcc);
                    if (depAccount != null) {
                        try {
                            depAccount.deposit(depositAmt);
                            System.out.println("Deposit successful!");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter account number to withdraw from: ");
                    String withdrawAcc = scanner.nextLine();
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmt = scanner.nextDouble();
                    scanner.nextLine();

                    BankAccount withAccount = bankService.findAccount(withdrawAcc);
                    if (withAccount != null) {
                        try {
                            withAccount.withdraw(withdrawAmt);
                            System.out.println("Withdrawal successful!");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }

        scanner.close();
    }
}
