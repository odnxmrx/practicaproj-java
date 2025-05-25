package models;

public class Purchase implements Comparable<Purchase>{
    private double price;
    private String description;

    // Metodo constructor
    public Purchase(String description, double price) {
        this.price = price;
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    // Sobre-escribir el toString

    @Override
    public String toString() {
        return "Purchase:" +
                "price=" + price +
                ", description='" + description;
    }

    @Override
    public int compareTo(Purchase otherPurchase) {
        return Double.valueOf(this.price).compareTo(Double.valueOf(otherPurchase.getPrice()));
    }
}
