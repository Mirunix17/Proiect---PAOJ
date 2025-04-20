package main;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        FoodDeliveryService service = new FoodDeliveryService();

        Restaurant r1 = new Restaurant("Pizza Hut", "Sos. Colentina nr. 1");
        r1.addItem(new MenuItem("Pizza Margherita", 25.0));
        r1.addItem(new MenuItem("Pizza Quattro Stagioni", 32.0));
        r1.addItem(new MenuItem("Pizza Roma", 33.0));
        r1.addItem(new MenuItem("Pizza California", 28.0));

        Restaurant r2 = new Restaurant("Il Calcio", "Floreasca");
        r2.addItem(new MenuItem("Spaghetti Carbonara", 65.0));
        r2.addItem(new MenuItem("Rigatoni Bolognese", 61.0));
        r2.addItem(new MenuItem("Spaghetti Pomodori Fresco", 57.0));

        Restaurant r3 = new Restaurant("Mc Donald's", "Veranda Mall");
        r3.addItem(new MenuItem("McPuisor", 16.0));
        r3.addItem(new MenuItem("McCrispy", 18.0));
        r3.addItem(new MenuItem("Big Mac", 23.0));
        r3.addItem(new MenuItem("Big Tasty", 25.0));

        Client c1 = new Client("Maria Vuletescu", "maria.vuletescu@gmail.com", "Str. Dorobanti nr. 10");
        Client c2 = new Client("Luca Croitoru", "luca.croitoru@gmail.com", "Aleea Lalelelor nr. 27");
        Client c3 = new Client("Mirabela Pescariu", "mirabela.pescariu@yahoo.com", "Str. Libertatii nr. 18");

        Driver d1 = new Driver("George Eftimie", "george.eftimie@yahoo.com", "B-12-MLN");
        Driver d2 = new Driver("Claudiu Ceara", "claudiu.ceara@gmail.com", "CJ-53-JKA");
        Driver d3 = new Driver("Sandra Ionescu", "sandra.ionescu@gmail.com", "GL-37-ZXI");

        service.addRestaurant(r1);
        service.addRestaurant(r2);
        service.addRestaurant(r3);

        service.registerClient(c1);
        service.registerClient(c2);
        service.registerClient(c3);

        service.registerDriver(d1);
        service.registerDriver(d2);
        service.registerDriver(d3);

        List<MenuItem> orderedItems = new ArrayList<>();
        orderedItems.add(r1.getMenu().get(0));
        Order o1 = new Order(c1, r1, orderedItems, d1);
        service.placeOrder(o1);

        Rating rating1 = new Rating(5, "Super buna pizza!", "maria.vuletescu@gmail.com");
        r1.addRating(rating1);

        System.out.println("\n--- Ratinguri pentru " + r1.getName() + " ---");
        for (Rating r : r1.getRatings()) {
            System.out.println("Rating de la " + r.getReviewerEmail() + ": " + r.getStars() + " stele - " + r.getComment());
        }
        System.out.println("Media ratingurilor: " + r1.getAverageRating());


        System.out.println("\nComenzi pentru client: " + service.getOrdersForClient("maria.vuletescu@gmail.com").size());

        System.out.println("\nMeniu sortat:");
        for (MenuItem item : service.getSortedMenu("Pizza Hut")) {
            System.out.println(item.getName() + ": " + item.getPrice());
        }

        // Listare comenzi cu detalii
        System.out.println("\n--- Toate comenzile din sistem ---");
        for (Order order : service.getAllOrders()) {
            System.out.println("Comanda " + order.getId());
            System.out.println("Client: " + order.getClient().getName());
            System.out.println("Sofer: " + order.getDriver().getName());
            System.out.println("Produse:");
            for (MenuItem item : order.getItems()) {
                System.out.println(" - " + item.getName() + " (" + item.getPrice() + " lei)");
            }
            System.out.println("Total: " + order.getTotalPrice() + " lei\n");
        }

        // Listare toti clientii
        System.out.println("--- Clienti inregistrati ---");
        for (Client client : service.getAllClients()) {
            System.out.println(client.getName() + " | Email: " + client.getEmail() + " | Adresa: " + client.getAddress());
        }

        // Listare toti șoferii
        System.out.println("\n--- Soferi inregistrati ---");
        for (Driver driver : service.getAllDrivers()) {
            System.out.println(driver.getName() + " | Email: " + driver.getEmail() + " | Masina: " + driver.getCarNumber());
        }

    }
}
