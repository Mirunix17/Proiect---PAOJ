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
        return Double.compare(this.price, other.price);
    }
}
