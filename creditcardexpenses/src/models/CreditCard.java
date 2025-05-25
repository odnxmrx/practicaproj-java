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

    // Metodo Bool que permite el ejecutar una compra dependiendo el balance
    public boolean throwPurchase(Purchase purchase){
        if(this.balance >= purchase.getPrice()){
            this.balance -= purchase.getPrice();
            this.myPurchaseList.add(purchase);
            return true;
        }
        return false;
    }

    public double getLimit() {
        return limit;
    }

    public double getBalance() {
        return balance;
    }

    public List<Purchase> getMyPurchaseList() {
        return myPurchaseList;
    }
}
