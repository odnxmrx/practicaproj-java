package main;

import models.CreditCard;
import models.Purchase;

import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        System.out.println("Enter your credit card limit: ");
        double limit = lectura.nextDouble();
        CreditCard myCard = new CreditCard(limit);

        int exit = 1;
        while(exit != 0) {

            // TODO validar el input, que sea lo que yo espero.

            System.out.println("Enter item description:");
            lectura.nextLine(); // prevent consuming the newline (leftover newline after the nextDouble)
            String description = lectura.nextLine();

            System.out.println("Enter purchase value $:");
            double valor = Double.valueOf(lectura.nextLine());

            Purchase purchase = new Purchase(description, valor);
            boolean purchaseMade = myCard.throwPurchase(purchase);

            if (purchaseMade) {
                System.out.println("Purchase made!");
                System.out.println("Type 0 to exit, or 1 to continue...");
                exit = lectura.nextInt();
            } else {
                System.out.println("sorry, insufficient balance!");
                exit = 0;
            }
        }
        System.out.println("***********************");
        System.out.println("PURCHASE LIST:\n");

        // TODO Order my list of puraches
        Collections.sort(myCard.getMyPurchaseList());

        for (Purchase myPurchase : myCard.getMyPurchaseList()) {
            System.out.println(myPurchase.getDescription() + " - " +myPurchase.getPrice());
        }
        System.out.println("\n***********************");
        System.out.println("\nCredit card balance: " +myCard.getBalance());

    }
}
