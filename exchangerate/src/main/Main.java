package main;

import enums.CurrencyCode;
import helpers.ExchangeRate;
import models.ConversionRate;
import models.ExchangeRateDto;

import java.util.Scanner;

import static helpers.Utils.displayAvailableCurrencies;
import static helpers.Utils.displayWelcomeMessage;

public class Main {
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        // New instance
        ExchangeRate rateFromApi = new ExchangeRate();

        try {
            displayWelcomeMessage();
            displayAvailableCurrencies();
            var newVal = Integer.parseInt(userInput.nextLine());

            var firstCurrency = CurrencyCode.values()[newVal];
            displayAvailableCurrencies();
            newVal = Integer.parseInt(userInput.nextLine());
            var secondCurrency = CurrencyCode.values()[newVal];

            System.out.println("Enter amount: ");
            var amountVal = Integer.parseInt(userInput.nextLine());

            ExchangeRateDto objectApi = rateFromApi.searchRate(firstCurrency, secondCurrency, amountVal);

            ConversionRate newConversion = new ConversionRate(objectApi);
            System.out.println(newConversion);
            System.out.println("La conversión fue: $" + newConversion.getConversionResult());
        } catch (NumberFormatException e) {
            System.out.println("Number format ex. " + e.getMessage());
        }
    }
}
