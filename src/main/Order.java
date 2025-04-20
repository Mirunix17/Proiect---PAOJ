package main;

import java.util.*;

public class Order {
    private UUID id;
    private Client client;
    private Restaurant restaurant;
    private List<MenuItem> items;
    private Driver driver;

    public Order(Client client, Restaurant restaurant, List<MenuItem> items, Driver driver) {
        this.id = UUID.randomUUID();
        this.client = client;
        this.restaurant = restaurant;
        this.items = items;
        this.driver = driver;
    }

    public UUID getId() { return id; }
    public Client getClient() { return client; }
    public Restaurant getRestaurant() { return restaurant; }
    public List<MenuItem> getItems() { return items; }
    public Driver getDriver() { return driver; }

    public double getTotalPrice() {
        return items.stream().mapToDouble(MenuItem::getPrice).sum();
    }
}
