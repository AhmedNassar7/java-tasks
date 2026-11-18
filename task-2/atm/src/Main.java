import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter PIN: ");
        int PIN = scan.nextInt();
        int attemp = 0;
        while (PIN != 1234) {
            System.out.println("Invalid PIN");
            System.out.print("Enter Valid PIN: ");
            PIN = scan.nextInt();
            attemp++;
            if (attemp == 3) {
                System.out.println("Your account has been locked");
                System.exit(0);
            }
        }

        double balance = 2500.75;
        int option = 0, depositCount = 0, withdrawalCount = 0;
        outer:
        while (true) {
            System.out.println();
            System.out.println("==========ATM==========");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Show Account Status");
            System.out.println("5. Exit");
            System.out.println("==========ATM==========");
            System.out.print("Enter Option: ");
            option = scan.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Current Balance = " + balance);
                    break;
                case 2:
                    System.out.print("Enter Deposit Amount: ");
                    int deposit = scan.nextInt();
                    while (deposit <= 0) {
                        System.out.println("Invalid Amount");
                        System.out.print("Enter Valid Deposit Amount: ");
                        deposit = scan.nextInt();
                    }
                    balance += deposit;
                    depositCount++;
                    System.out.println("Updated Balance = " + balance);
                    break;
                case 3:
                    System.out.print("Enter Withdraw Amount: ");
                    int withdraw = scan.nextInt();
                    while (withdraw < 0 || withdraw > balance) {
                        if (withdraw < 0) {
                            System.out.println("Invalid Amount");
                        } else if (withdraw > balance) {
                            System.out.println("Insufficient balance");
                        }
                        System.out.print("Enter Withdraw Amount: ");
                        withdraw = scan.nextInt();
                    }
                    if (withdraw == 0) {
                        System.out.println("Transaction cancelled");
                    }
                    if (balance == withdraw) {
                        System.out.println("Warning: Your account is empty");
                    }
                    balance -= withdraw;
                    withdrawalCount++;
                    System.out.println("Updated Balance = " + balance);
                    break;
                case 4:
                    if (balance >= 5000) {
                        System.out.println("VIP Customer");
                    } else if (balance >= 1000) {
                        System.out.println("Regular Customer");
                    } else {
                        System.out.println("Low Balance");
                    }
                    break;
                case 5:
                    System.out.println("Thank you for using our ATM");
                    break outer;
                default:
                    do {
                        System.out.println("Invalid Option");
                        System.out.print("Enter Valid Option: ");
                        option = scan.nextInt();
                    } while (option < 1 && option > 5);
                    break;
            }
        }
        System.out.println();
        System.out.println("Deposits Counts: " + depositCount);
        System.out.println("Withdrawals Counts: " + withdrawalCount);
    }
}