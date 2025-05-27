package helpers;

import enums.CurrencyCode;

public class Utils {

    public static void displayWelcomeMessage(){
        System.out.println("""
        ********Welcome*******
        *Exchange rating app!*
        *********************
        """);
    }

    // Display available currency rates
    public static void displayAvailableCurrencies() {
        for (CurrencyCode currency : CurrencyCode.values()) {
            System.out.println("Currency " + currency.ordinal() + ": " + currency);
        }
        System.out.println("Please, enter the number corresponding a Currency code:");
    }
}
