package main;

import helpers.ExchangeRate;
import models.ConversionRate;
import models.ExchangeRateDto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("""
        ********Welcome*******
        *Exchange rating app!*
        *********************
        """);

        Scanner userInput = new Scanner(System.in);
        System.out.println("Please, enter a number");
        // New instance
        ExchangeRate rateFromApi = new ExchangeRate();

        try {
            var newVal = Integer.parseInt(userInput.nextLine());

            ExchangeRateDto objectApi = rateFromApi.searchRate(newVal);

            ConversionRate newConversion = new ConversionRate(objectApi);
            System.out.println(newConversion);
            System.out.println("La conversión fue: $" + newConversion.getConversionResult());
        } catch (NumberFormatException e) {
            System.out.println("Number format ex. " + e.getMessage());
        }
    }
}
