package main;

public class MenuItem implements Comparable<MenuItem> {
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }

    @Override
    public int compareTo(MenuItem other) {
        int priceCompare = Double.compare(this.price, other.price);
        if (priceCompare == 0) {
            return this.name.compareTo(other.name);
        }
        return priceCompare;
    }

    @Override
    public String toString() {
        return name + " - " + price + " RON";
    }
}
