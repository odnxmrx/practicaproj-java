import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        // Inicializamos variables
        String clientName = "Armando Gama";
        String accountTipe = "Regular";
        double balance = 2610.50;
        int selectedOption = 0;
        String optionsMenu = """
                ** Please, enter the number of the desired transaction: **
                1 - Balance
                2 - Withdrawal
                3 - Deposit
                9 - Exit
                """;

        System.out.println("-------------\n");
        System.out.println("Client name: " + clientName);
        System.out.println("Your account type: " + accountTipe);
        System.out.println("Your current balance is: $" + balance);
        System.out.println("\n-------------");

        Scanner keyboardInput = new Scanner(System.in);
        while (selectedOption != 9){
            System.out.println(optionsMenu);
            selectedOption = keyboardInput.nextInt();

            // Navigate to selected option
            switch (selectedOption){
                case 1:
                    System.out.println("Your current balance is: $" + balance);
                    break;
                case 2:
                    System.out.println("Amount to withdraw?");
                    double desiredAmountToWithdraw = keyboardInput.nextDouble();
                    if (balance < desiredAmountToWithdraw){
                        System.out.println("Sorry, your balance is not enough.");
                    } else {
                        balance -= desiredAmountToWithdraw;
                        System.out.println("Your updated balance is: $" + balance);
                    }
                    break;
                case 3:
                    System.out.println("Amount to deposit?");
                    double amountToDeposit = keyboardInput.nextDouble();
                    balance += amountToDeposit;
                    System.out.println("Your updated balance is: $" + balance);
                    break;
                case 9:
                    System.out.println("Exiting now. Thank you for trusting in us.");
                    break;
                default:
                    System.out.println("Option is not valid. Please, enter a valid number.");
            }
        }
    }
}
