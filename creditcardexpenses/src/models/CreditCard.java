package models;

import java.util.ArrayList;
import java.util.List;

public class CreditCard {
    private double limit;
    private double balance;
    private List<Purchase> myPurchaseList;

    // Metodo constructor
    public CreditCard(double limit){
        this.limit = limit;
        this.balance = limit;
        this.myPurchaseList = new ArrayList<>();
    }

    // Metodo Bool que permite el ejecutar una compra
    public boolean throwPurchase(Purchase purchase){
        return false;
    }

    public double getLimit() {
        return limit;
    }

    public double getBalance() {
        return balance;
    }
}
