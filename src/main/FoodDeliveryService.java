//package main;
//
//import java.util.*;
//
//public class FoodDeliveryService {
//    private Map<String, Restaurant> restaurants = new HashMap<>();
//    private List<Client> clients = new ArrayList<>();
//    private List<Driver> drivers = new ArrayList<>();
//    private List<Order> orders = new ArrayList<>();
//
//    public void addRestaurant(Restaurant restaurant) {
//        restaurants.put(restaurant.getName(), restaurant);
//    }
//
//    public void registerClient(Client client) {
//        clients.add(client);
//    }
//
//    public void registerDriver(Driver driver) {
//        drivers.add(driver);
//    }
//
//    public void placeOrder(Order order) {
//        orders.add(order);
//    }
//
//    public List<Order> getOrdersForClient(String clientEmail) {
//        return orders.stream()
//                .filter(o -> o.getClient().getEmail().equals(clientEmail))
//                .toList();
//    }
//
//    public Set<MenuItem> getSortedMenu(String restaurantName) {
//        if (!restaurants.containsKey(restaurantName)) return Set.of();
//        return new TreeSet<>(restaurants.get(restaurantName).getMenu());
//    }
//
//    public List<Driver> getAllDrivers() {
//        return drivers;
//    }
//
//    public List<Client> getAllClients() {
//        return clients;
//    }
//
//    public List<Order> getAllOrders() {
//        return orders;
//    }
//
//    public Collection<Restaurant> getAllRestaurants() {
//        return restaurants.values();
//    }
//
//    public Restaurant getRestaurantByName(String name) {
//        return restaurants.get(name);
//    }
//
//    public Client getClientByEmail(String email) {
//        return clients.stream()
//                .filter(c -> c.getEmail().equals(email))
//                .findFirst()
//                .orElse(null);
//    }
//
//    public Driver getRandomDriver() {
//        if (drivers.isEmpty()) return null;
//        Random rand = new Random();
//        return drivers.get(rand.nextInt(drivers.size()));
//    }
//}

package main;

import java.util.*;

public class FoodDeliveryService {
    private Map<String, Restaurant> restaurants = new HashMap<>();
    private List<Client> clients = new ArrayList<>();
    private List<Driver> drivers = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();

    public void addRestaurant(Restaurant restaurant) {
        restaurants.put(restaurant.getName(), restaurant);
    }

    public void registerClient(Client client) {
        clients.add(client);
    }

    public void registerDriver(Driver driver) {
        drivers.add(driver);
    }

    public void placeOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrdersForClient(String clientEmail) {
        return orders.stream()
                .filter(o -> o.getClient().getEmail().equals(clientEmail))
                .toList();
    }

    public Set<MenuItem> getSortedMenu(String restaurantName) {
        if (!restaurants.containsKey(restaurantName)) return Set.of();
        return new TreeSet<>(restaurants.get(restaurantName).getMenu());
    }

    public List<Driver> getAllDrivers() {
        return drivers;
    }

    public List<Client> getAllClients() {
        return clients;
    }

    public List<Order> getAllOrders() {
        return orders;
    }

    public Collection<Restaurant> getAllRestaurants() {
        return restaurants.values();
    }

    public Restaurant getRestaurantByName(String name) {
        return restaurants.get(name);
    }

    public Client getClientByEmail(String email) {
        return clients.stream()
                .filter(c -> c.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    public Driver getRandomDriver() {
        if (drivers.isEmpty()) return null;
        Random rand = new Random();
        return drivers.get(rand.nextInt(drivers.size()));
    }
}
