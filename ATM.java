import java.util.Scanner;

public class ATM {
    private double balance;
    private Scanner scanner;

    public ATM() {
        this.balance = 0.0;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\nATM Machine");
            System.out.println("Choose 1 for Withdraw");
            System.out.println("Choose 2 for Deposit");
            System.out.println("Choose 3 for Check Balance");
            System.out.println("Choose 4 for EXIT");
            System.out.print("Choose the operation: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    exit();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void withdraw() {
        System.out.print("Enter money to be withdrawn: ");
        double amount = scanner.nextDouble();

        if (balance >= amount) {
            balance -= amount;
            System.out.println("Please collect your money.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    private void deposit() {
        System.out.print("Enter money to be deposited: ");
        double amount = scanner.nextDouble();
        balance += amount;
        System.out.println("Your money has been successfully deposited.");
    }

    private void checkBalance() {
        System.out.println("Balance: " + balance);
    }

    private void exit() {
        System.out.println("Thank you for using the ATM. Goodbye!");
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.start();
    }
}
