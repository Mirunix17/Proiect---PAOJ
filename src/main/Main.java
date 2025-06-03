////package main;
////
//////import db.DatabaseConnection;
//////import main.*;
//////import service.*;
////
////import java.sql.SQLException;
////import java.util.*;
////
////public class Main {
////    public static void main(String[] args) throws SQLException {
////        FoodDeliveryService service = new FoodDeliveryService();
////
////        Restaurant r1 = new Restaurant("Pizza Hut", "Sos. Colentina nr. 1");
////        r1.addItem(new MenuItem("Pizza Margherita", 25.0));
////        r1.addItem(new MenuItem("Pizza Quattro Stagioni", 32.0));
////        r1.addItem(new MenuItem("Pizza Roma", 33.0));
////        r1.addItem(new MenuItem("Pizza California", 28.0));
////
////        Restaurant r2 = new Restaurant("Il Calcio", "Floreasca");
////        r2.addItem(new MenuItem("Spaghetti Carbonara", 65.0));
////        r2.addItem(new MenuItem("Rigatoni Bolognese", 61.0));
////        r2.addItem(new MenuItem("Spaghetti Pomodori Fresco", 57.0));
////
////        Restaurant r3 = new Restaurant("Mc Donald's", "Veranda Mall");
////        r3.addItem(new MenuItem("McPuisor", 16.0));
////        r3.addItem(new MenuItem("McCrispy", 18.0));
////        r3.addItem(new MenuItem("Big Mac", 23.0));
////        r3.addItem(new MenuItem("Big Tasty", 25.0));
////
////        Client c1 = new Client("Maria Vuletescu", "maria.vuletescu@gmail.com", "Str. Dorobanti nr. 10");
////        Client c2 = new Client("Luca Croitoru", "luca.croitoru@gmail.com", "Aleea Lalelelor nr. 27");
////        Client c3 = new Client("Mirabela Pescariu", "mirabela.pescariu@yahoo.com", "Str. Libertatii nr. 18");
////
////        Driver d1 = new Driver("George Eftimie", "george.eftimie@yahoo.com", "B-12-MLN");
////        Driver d2 = new Driver("Claudiu Ceara", "claudiu.ceara@gmail.com", "CJ-53-JKA");
////        Driver d3 = new Driver("Sandra Ionescu", "sandra.ionescu@gmail.com", "GL-37-ZXI");
////
////        service.addRestaurant(r1);
////        service.addRestaurant(r2);
////        service.addRestaurant(r3);
////
////        service.registerClient(c1);
////        service.registerClient(c2);
////        service.registerClient(c3);
////
////        service.registerDriver(d1);
////        service.registerDriver(d2);
////        service.registerDriver(d3);
////
////        List<MenuItem> orderedItems = new ArrayList<>();
////        orderedItems.add(r1.getMenu().get(0));
////        Order o1 = new Order(c1, r1, orderedItems, d1);
////        service.placeOrder(o1);
////
////        Rating rating1 = new Rating(5, "Super buna pizza!", "maria.vuletescu@gmail.com");
////        r1.addRating(rating1);
////
////        DatabaseConnection connection1 = new DatabaseConnection();
////
//////        System.out.println(connection1.getConnection());
//////
//////        System.out.println("\n--- Ratinguri pentru " + r1.getName() + " ---");
//////        for (Rating r : r1.getRatings()) {
//////            System.out.println("Rating de la " + r.getReviewerEmail() + ": " + r.getStars() + " stele - " + r.getComment());
//////        }
//////        System.out.println("Media ratingurilor: " + r1.getAverageRating());
//////
//////
//////        System.out.println("\nComenzi pentru client: " + service.getOrdersForClient("maria.vuletescu@gmail.com").size());
//////
//////        System.out.println("\nMeniu sortat:");
//////        for (MenuItem item : service.getSortedMenu("Pizza Hut")) {
//////            System.out.println(item.getName() + ": " + item.getPrice());
//////        }
//////
//////        // Listare comenzi cu detalii
//////        System.out.println("\n--- Toate comenzile din sistem ---");
//////        for (Order order : service.getAllOrders()) {
//////            System.out.println("Comanda " + order.getId());
//////            System.out.println("Client: " + order.getClient().getName());
//////            System.out.println("Sofer: " + order.getDriver().getName());
//////            System.out.println("Produse:");
//////            for (MenuItem item : order.getItems()) {
//////                System.out.println(" - " + item.getName() + " (" + item.getPrice() + " lei)");
//////            }
//////            System.out.println("Total: " + order.getTotalPrice() + " lei\n");
//////        }
//////
//////        // Listare toti clientii
//////        System.out.println("--- Clienti inregistrati ---");
//////        for (Client client : service.getAllClients()) {
//////            System.out.println(client.getName() + " | Email: " + client.getEmail() + " | Adresa: " + client.getAddress());
//////        }
//////
//////        // Listare toti șoferii
//////        System.out.println("\n--- Soferi inregistrati ---");
//////        for (Driver driver : service.getAllDrivers()) {
//////            System.out.println(driver.getName() + " | Email: " + driver.getEmail() + " | Masina: " + driver.getCarNumber());
//////        }
////
////        Scanner scanner = new Scanner(System.in);
////
////        while (true) {
////            System.out.println("--- Meniu Principal ---");
////            System.out.println("1. Sunt client");
////            System.out.println("2. Sunt șofer (neimplementat încă)");
////            System.out.println("3. Ies din program");
////            System.out.print("Alege o opțiune: ");
////            String opt = scanner.nextLine();
////
////            switch (opt) {
////                case "1":
////                    clientMenu(service, scanner);
////                    break;
////                case "2":
////                    System.out.println("Funcționalitățile pentru șoferi vor fi adăugate.");
////                    break;
////                case "3":
////                    System.out.println("Ieșire...");
////                    return;
////                default:
////                    System.out.println("Opțiune invalidă. Încearcă din nou.");
////            }
////        }
////    }
////
////    private static void clientMenu(FoodDeliveryService service, Scanner scanner) {
////        System.out.print("Introdu adresa ta de email: ");
////        String email = scanner.nextLine();
////
////        while (true) {
////            System.out.println("\n--- Meniu Client ---");
////            System.out.println("1. Afișează toate restaurantele");
////            System.out.println("2. Afișează meniul sortat pentru un restaurant");
////            System.out.println("3. Afișează ratinguri pentru un restaurant");
////            System.out.println("4. Vezi comenzile mele");
////            System.out.println("5. Plasează o comandă nouă");
////            System.out.println("6. Înapoi la meniul principal");
////            System.out.print("Alege o opțiune: ");
////            String opt = scanner.nextLine();
////
////            switch (opt) {
////                case "1":
////                    for (Restaurant r : service.getAllRestaurants()) {
////                        System.out.println(r.getName() + " | Adresă: " + r.getLocation());
////                    }
////                    break;
////                case "2":
////                    System.out.print("Introdu numele restaurantului: ");
////                    String restaurantNameSort = scanner.nextLine();
////                    Set<MenuItem> sortedMenu = service.getSortedMenu(restaurantNameSort);
////
////                    if (sortedMenu.isEmpty()) {
////                        System.out.println("Restaurantul nu a fost găsit sau nu are meniu.");
////                    } else {
////                        for (MenuItem item : sortedMenu) {
////                            System.out.println(item.getName() + " - " + item.getPrice() + " lei");
////                        }
////                    }
////                    break;
////                case "3":
////                    System.out.print("Introdu numele restaurantului: ");
////                    String restaurantNameRatings = scanner.nextLine();
////                    Restaurant r = service.getName(restaurantNameRatings);
////
////                    if (r == null) {
////                        System.out.println("Restaurantul nu a fost găsit.");
////                    } else {
////                        for (Rating rating : r.getRatings()) {
////                            System.out.println(rating.getReviewerEmail() + ": " + rating.getStars() + " stele - " + rating.getComment());
////                        }
////                        System.out.println("Media ratingurilor: " + r.getAverageRating());
////                    }
////                    break;
////                case "4":
////                    List<Order> orders = service.getOrdersForClient(email);
////                    for (Order order : orders) {
////                        System.out.println("Comanda " + order.getId() + ", Restaurant: " + order.getRestaurant().getName() + ", Total: " + order.getTotalPrice());
////                    }
////                    break;
////                case "5":
////                    System.out.print("Introdu numele restaurantului: ");
////                    String restForOrder = scanner.nextLine();
////                    Restaurant rest = service.getRestaurantByName(restForOrder);
////                    if (rest == null) {
////                        System.out.println("Restaurantul nu a fost găsit.");
////                        break;
////                    }
////                    List<MenuItem> menu = rest.getMenu();
////                    List<MenuItem> selectedItems = new ArrayList<>();
////                    while (true) {
////                        System.out.println("Meniu:");
////                        for (int i = 0; i < menu.size(); i++) {
////                            System.out.println((i + 1) + ". " + menu.get(i).getName() + " - " + menu.get(i).getPrice());
////                        }
////                        System.out.print("Alege produsul (0 pentru a termina): ");
////                        int choice = Integer.parseInt(scanner.nextLine());
////                        if (choice == 0) break;
////                        if (choice >= 1 && choice <= menu.size()) {
////                            selectedItems.add(menu.get(choice - 1));
////                        } else {
////                            System.out.println("Selecție invalidă.");
////                        }
////                    }
////                    Client client = service.getClientByEmail(email);
////                    Driver driver = service.getRandomDriver();
////                    if (client == null || driver == null || selectedItems.isEmpty()) {
////                        System.out.println("Eroare: clientul sau șoferul sau produsele nu sunt valide.");
////                    } else {
////                        Order order = new Order(client, rest, selectedItems, driver);
////                        service.placeOrder(order);
////                        System.out.println("Comandă plasată cu succes. Total: " + order.getTotalPrice() + " lei");
////                    }
////                    break;
////                case "6":
////                    return;
////                default:
////                    System.out.println("Opțiune invalidă. Încearcă din nou.");
////            }
////        }
////    }
////
////    }
////}
//
//
//package main;
//
//import java.sql.SQLException;
//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) throws SQLException {
//        FoodDeliveryService service = new FoodDeliveryService();
//
//        // Inițializare restaurante
//        Restaurant r1 = new Restaurant("Pizza Hut", "Sos. Colentina nr. 1");
//        r1.addItem(new MenuItem("Pizza Margherita", 25.0));
//        r1.addItem(new MenuItem("Pizza Quattro Stagioni", 32.0));
//        r1.addItem(new MenuItem("Pizza Roma", 33.0));
//        r1.addItem(new MenuItem("Pizza California", 28.0));
//
//        Restaurant r2 = new Restaurant("Il Calcio", "Floreasca");
//        r2.addItem(new MenuItem("Spaghetti Carbonara", 65.0));
//        r2.addItem(new MenuItem("Rigatoni Bolognese", 61.0));
//        r2.addItem(new MenuItem("Spaghetti Pomodori Fresco", 57.0));
//
//        Restaurant r3 = new Restaurant("Mc Donald's", "Veranda Mall");
//        r3.addItem(new MenuItem("McPuisor", 16.0));
//        r3.addItem(new MenuItem("McCrispy", 18.0));
//        r3.addItem(new MenuItem("Big Mac", 23.0));
//        r3.addItem(new MenuItem("Big Tasty", 25.0));
//
//        // Inițializare clienți
//        Client c1 = new Client("Maria Vuletescu", "maria.vuletescu@gmail.com", "Str. Dorobanti nr. 10");
//        Client c2 = new Client("Luca Croitoru", "luca.croitoru@gmail.com", "Aleea Lalelelor nr. 27");
//        Client c3 = new Client("Mirabela Pescariu", "mirabela.pescariu@yahoo.com", "Str. Libertatii nr. 18");
//
//        // Inițializare șoferi
//        Driver d1 = new Driver("George Eftimie", "george.eftimie@yahoo.com", "B-12-MLN");
//        Driver d2 = new Driver("Claudiu Ceara", "claudiu.ceara@gmail.com", "CJ-53-JKA");
//        Driver d3 = new Driver("Sandra Ionescu", "sandra.ionescu@gmail.com", "GL-37-ZXI");
//
//        // Adăugare în serviciu
//        service.addRestaurant(r1);
//        service.addRestaurant(r2);
//        service.addRestaurant(r3);
//
//        service.registerClient(c1);
//        service.registerClient(c2);
//        service.registerClient(c3);
//
//        service.registerDriver(d1);
//        service.registerDriver(d2);
//        service.registerDriver(d3);
//
//        // Plasare comandă de test
//        List<MenuItem> orderedItems = new ArrayList<>();
//        orderedItems.add(r1.getMenu().get(0)); // Pizza Margherita
//        Order o1 = new Order(c1, r1, orderedItems, d1);
//        service.placeOrder(o1);
//
//        // Adăugare rating
//        Rating rating1 = new Rating(5, "Super buna pizza!", "maria.vuletescu@gmail.com");
//        r1.addRating(rating1);
//
//        // Interfață utilizator
//        Scanner scanner = new Scanner(System.in);
//
//        while (true) {
//            System.out.println("\n--- Meniu Principal ---");
//            System.out.println("1. Sunt client");
//            System.out.println("2. Sunt șofer (neimplementat încă)");
//            System.out.println("3. Ies din program");
//            System.out.print("Alege o opțiune: ");
//            String opt = scanner.nextLine();
//
//            switch (opt) {
//                case "1":
//                    clientMenu(service, scanner);
//                    break;
//                case "2":
//                    System.out.println("Funcționalitățile pentru șoferi vor fi adăugate.");
//                    break;
//                case "3":
//                    System.out.println("Ieșire...");
//                    return;
//                default:
//                    System.out.println("Opțiune invalidă. Încearcă din nou.");
//            }
//        }
//    }
//
//    private static void clientMenu(FoodDeliveryService service, Scanner scanner) {
//        System.out.print("Introdu adresa ta de email: ");
//        String email = scanner.nextLine();
//
//        while (true) {
//            System.out.println("\n--- Meniu Client ---");
//            System.out.println("1. Afișează toate restaurantele");
//            System.out.println("2. Afișează meniul sortat pentru un restaurant");
//            System.out.println("3. Afișează ratinguri pentru un restaurant");
//            System.out.println("4. Vezi comenzile mele");
//            System.out.println("5. Plasează o comandă nouă");
//            System.out.println("6. Înapoi la meniul principal");
//            System.out.print("Alege o opțiune: ");
//            String opt = scanner.nextLine();
//            System.out.println("\n");
//
//            switch (opt) {
//                case "1":
//                    for (Restaurant r : service.getAllRestaurants()) {
//                        System.out.println(r.getName() + " | Adresă: " + r.getLocation());
//                    }
//                    break;
//                case "2":
//                    System.out.print("Introdu numele restaurantului: ");
//                    String restaurantNameSort = scanner.nextLine();
//                    Set<MenuItem> sortedMenu = service.getSortedMenu(restaurantNameSort);
//
//                    if (sortedMenu.isEmpty()) {
//                        System.out.println("Restaurantul nu a fost găsit sau nu are meniu.");
//                    } else {
//                        for (MenuItem item : sortedMenu) {
//                            System.out.println(item.getName() + " - " + item.getPrice() + " lei");
//                        }
//                    }
//                    break;
//                case "3":
//                    System.out.print("Introdu numele restaurantului: ");
//                    String restaurantNameRatings = scanner.nextLine();
//                    Restaurant r = service.getRestaurantByName(restaurantNameRatings);
//
//                    if (r == null) {
//                        System.out.println("Restaurantul nu a fost găsit.");
//                    } else {
//                        for (Rating rating : r.getRatings()) {
//                            System.out.println(rating.getReviewerEmail() + ": " + rating.getStars() + " stele - " + rating.getComment());
//                        }
//                        System.out.println("Media ratingurilor: " + r.getAverageRating());
//                    }
//                    break;
//                case "4":
//                    List<Order> orders = service.getOrdersForClient(email);
//                    for (Order order : orders) {
//                        System.out.println("Comanda " + order.getId() + ", Restaurant: " + order.getRestaurant().getName() + ", Total: " + order.getTotalPrice());
//                    }
//                    break;
//                case "5":
//                    System.out.print("Introdu numele restaurantului: ");
//                    String restForOrder = scanner.nextLine();
//                    Restaurant rest = service.getRestaurantByName(restForOrder);
//                    if (rest == null) {
//                        System.out.println("Restaurantul nu a fost găsit.");
//                        break;
//                    }
//                    List<MenuItem> menu = rest.getMenu();
//                    List<MenuItem> selectedItems = new ArrayList<>();
//                    while (true) {
//                        System.out.println("Meniu:");
//                        for (int i = 0; i < menu.size(); i++) {
//                            System.out.println((i + 1) + ". " + menu.get(i).getName() + " - " + menu.get(i).getPrice());
//                        }
//                        System.out.print("Alege produsul (0 pentru a termina): ");
//                        int choice = Integer.parseInt(scanner.nextLine());
//                        if (choice == 0) break;
//                        if (choice >= 1 && choice <= menu.size()) {
//                            selectedItems.add(menu.get(choice - 1));
//                        } else {
//                            System.out.println("Selecție invalidă.");
//                        }
//                    }
//                    Client client = service.getClientByEmail(email);
//                    Driver driver = service.getRandomDriver();
//                    if (client == null || driver == null || selectedItems.isEmpty()) {
//                        System.out.println("Eroare: clientul sau șoferul sau produsele nu sunt valide.");
//                    } else {
//                        Order order = new Order(client, rest, selectedItems, driver);
//                        service.placeOrder(order);
//                        System.out.println("Comandă plasată cu succes. Total: " + order.getTotalPrice() + " lei");
//                    }
//                    break;
//                case "6":
//                    return;
//                default:
//                    System.out.println("Opțiune invalidă. Încearcă din nou.");
//            }
//        }
//    }
//}

package main;

import java.sql.SQLException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        FoodDeliveryService service = new FoodDeliveryService();
        ClientService clientService = ClientService.getInstance();
        DriverService driverService = DriverService.getInstance();


        // Inițializare restaurante
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

        // Inițializare clienți
        Client c1 = new Client("Maria Vuletescu", "maria.vuletescu@gmail.com", "Str. Dorobanti nr. 10");
        Client c2 = new Client("Luca Croitoru", "luca.croitoru@gmail.com", "Aleea Lalelelor nr. 27");
        Client c3 = new Client("Mirabela Pescariu", "mirabela.pescariu@yahoo.com", "Str. Libertatii nr. 18");

        // Inițializare șoferi
        Driver d1 = new Driver("George Eftimie", "george.eftimie@yahoo.com", "B-12-MLN");
        Driver d2 = new Driver("Claudiu Ceara", "claudiu.ceara@gmail.com", "CJ-53-JKA");
        Driver d3 = new Driver("Sandra Ionescu", "sandra.ionescu@gmail.com", "GL-37-ZXI");

        // Adăugare în serviciu
        service.addRestaurant(r1);
        service.addRestaurant(r2);
        service.addRestaurant(r3);

        service.registerClient(c1);
        service.registerClient(c2);
        service.registerClient(c3);

        service.registerDriver(d1);
        service.registerDriver(d2);
        service.registerDriver(d3);

        // Plasare comandă de test
        List<MenuItem> orderedItems = new ArrayList<>();
        orderedItems.add(r1.getMenu().get(0)); // Pizza Margherita
        Order o1 = new Order(c1, r1, orderedItems, d1);
        service.placeOrder(o1);

        // Adăugare rating
        Rating rating1 = new Rating(5, "Super buna pizza!", "maria.vuletescu@gmail.com", "Pizza Hut");
        r1.addRating(rating1);

        // Interfață utilizator
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Meniu Principal ---");
            System.out.println("1. Vreau sa imi fac cont de client");
            System.out.println("2. Sunt client");
            System.out.println("3. Sunt sofer");
            System.out.println("4. Sunt admin");
            System.out.println("5. Iesire din program");
            System.out.print("Alege o opțiune: ");
            String opt = scanner.nextLine();

            switch (opt) {
                case "1":
                    creeazaContClient(clientService, scanner);
                    break;
                case "2":
                    clientMenu(service, clientService, scanner);
                    break;
                case "3":
                    driverMenu(service, driverService, scanner);
                    break;
                case "4":
                    System.out.print("Introduceți parola de admin: ");
                    String parola = scanner.nextLine();
                    if (!parola.equals("123")) {
                        System.out.println("Parolă greșită!");
                    } else {
                        adminMenu(service, driverService, RestaurantService.getInstance(), scanner);
                    }
                    break;
                case "5":
                    System.out.println("Ieșire...");
                    return;
                default:
                    System.out.println("Opțiune invalidă. Încearcă din nou.");
            }
        }
    }

    private static void creeazaContClient(ClientService clientService, Scanner scanner) {
        System.out.print("Introdu numele: ");
        String name = scanner.nextLine();
        System.out.print("Introdu emailul: ");
        String email = scanner.nextLine();
        System.out.print("Introdu adresa: ");
        String address = scanner.nextLine();

        Client client = new Client(name, email, address);
        clientService.create(client);
        System.out.println("Contul a fost creat cu succes!");
    }


    private static void clientMenu(FoodDeliveryService service, ClientService clientService, Scanner scanner) {
        System.out.print("Introdu adresa ta de email: ");
        String email = scanner.nextLine();
        Client client = clientService.getByEmail(email);

        if (client == null) {
            System.out.println("Clientul nu a fost găsit.");
            return;
        }

        while (true) {
            System.out.println("\n--- Meniu Client ---");
            System.out.println("1. Vizualizează informații personale");
            System.out.println("2. Modifică informații personale");
            System.out.println("3. Șterge contul");
            System.out.println("4. Afișează toate restaurantele");
            System.out.println("5. Afișează meniul sortat pentru un restaurant");
            System.out.println("6. Afișează ratinguri pentru un restaurant");
            System.out.println("7. Vezi comenzile mele");
            System.out.println("8. Plasează o comandă nouă");
            System.out.println("9. Adaugă un rating");
            System.out.println("10. Modifică un rating");
            System.out.println("11. Afișează rating-urile mele");
            System.out.println("12. Șterge un rating - nefuncțional");
            System.out.println("13. Înapoi la meniul principal");
            System.out.print("Alege o opțiune: ");
            String opt = scanner.nextLine();

            switch (opt) {
                case "1":
                    System.out.println("Nume: " + client.getName());
                    System.out.println("Email: " + client.getEmail());
                    System.out.println("Adresă: " + client.getAddress());
                    break;
                case "2":
                    System.out.print("Nume nou: ");
                    String newName = scanner.nextLine();
                    System.out.print("Adresă nouă: ");
                    String newAddress = scanner.nextLine();
                    client.setName(newName);
                    client.setAddress(newAddress);
                    clientService.update(client);
                    System.out.println("Informațiile au fost actualizate.");
                    break;
                case "3":
                    System.out.print("Ești sigur că vrei să ștergi contul? (da/nu): ");
                    String confirm = scanner.nextLine();
                    if (confirm.equalsIgnoreCase("da")) {
                        clientService.deleteByEmail(email);
                        System.out.println("Contul a fost șters.");
                        return;
                    }
                    break;
                case "4":
                    for (Restaurant r : service.getAllRestaurants()) {
                        System.out.println(r.getName() + " | Adresă: " + r.getLocation());
                    }
                    break;
                case "5":
                    System.out.print("Introdu numele restaurantului: ");
                    String restaurantNameSort = scanner.nextLine();
                    Collection<MenuItem> sortedMenu = service.getSortedMenu(restaurantNameSort);
                    AuditService.getInstance().logAction("Obținere meniu sortat");

                    if (sortedMenu.isEmpty()) {
                        System.out.println("Restaurantul nu a fost găsit sau nu are meniu.");
                    } else {
                        for (MenuItem item : sortedMenu) {
                            System.out.println(item.getName() + " - " + item.getPrice() + " lei");
                        }
                    }
                    break;
                case "6":
                    System.out.print("Introdu numele restaurantului: ");
                    String restaurantNameRatings = scanner.nextLine();
                    Restaurant r = service.getRestaurantByName(restaurantNameRatings);

                    if (r == null) {
                        System.out.println("Restaurantul nu a fost găsit.");
                    } else {
                        for (Rating rating : r.getRatings()) {
                            System.out.println(rating.getReviewerEmail() + ": " + rating.getStars() + " stele - " + rating.getComment());
                        }
                        System.out.println("Media ratingurilor: " + r.getAverageRating());
                    }
                    break;
                case "7":
                    List<Order> orders = service.getOrdersForClient(email);
                    for (Order order : orders) {
                        System.out.println("Comanda " + order.getId() + ", Restaurant: " + order.getRestaurant().getName() + ", Total: " + order.getTotalPrice());
                    }
                    break;
                case "8":
                    System.out.print("Introdu numele restaurantului: ");
                    String restForOrder = scanner.nextLine();
                    Restaurant rest = service.getRestaurantByName(restForOrder);
                    if (rest == null) {
                        System.out.println("Restaurantul nu a fost găsit.");
                        break;
                    }
                    List<MenuItem> menu = rest.getMenu();
                    List<MenuItem> selectedItems = new ArrayList<>();
                    while (true) {
                        System.out.println("Meniu:");
                        for (int i = 0; i < menu.size(); i++) {
                            System.out.println((i + 1) + ". " + menu.get(i).getName() + " - " + menu.get(i).getPrice());
                        }
                        System.out.print("Alege produsul (0 pentru a termina): ");
                        int choice = Integer.parseInt(scanner.nextLine());
                        if (choice == 0) break;
                        if (choice >= 1 && choice <= menu.size()) {
                            selectedItems.add(menu.get(choice - 1));
                        } else {
                            System.out.println("Selecție invalidă.");
                        }
                    }

                    Driver driver = service.getRandomDriver();
                    if (client == null || driver == null || selectedItems.isEmpty()) {
                        System.out.println("Eroare: clientul sau șoferul sau produsele nu sunt valide.");
                    } else {
                        Order order = new Order(client, rest, selectedItems, driver);
                        service.placeOrder(order);
                        AuditService.getInstance().logAction("Plasare comanda");
                        System.out.println("Comandă plasată cu succes. Total: " + order.getTotalPrice() + " lei");
                    }
                    break;
                case "9":
                    System.out.print("Introdu numele restaurantului: ");
                    String restaurantNameForRating = scanner.nextLine();
                    Restaurant restaurantToRate = service.getRestaurantByName(restaurantNameForRating);

                    if (restaurantToRate == null) {
                        System.out.println("Restaurantul nu a fost găsit.");
                        break;
                    }

                    System.out.print("Ratingul (1-5): ");
                    int stars = Integer.parseInt(scanner.nextLine());
                    System.out.print("Comentariu: ");
                    String comment = scanner.nextLine();

                    Rating rating = new Rating(stars, comment, email, restaurantNameForRating);
                    restaurantToRate.addRating(rating); // dacă vrei să-l vezi și în `r.getRatings()`

                    RatingService.getInstance().create(rating);
                    System.out.println("Rating adăugat cu succes!");
                    break;
                case "10":
                    System.out.print("Introdu numele restaurantului pentru care vrei să modifici ratingul: ");
                    String restUpdate = scanner.nextLine();
                    System.out.print("Rating nou (1-5): ");
                    int newStars = Integer.parseInt(scanner.nextLine());
                    System.out.print("Comentariu nou: ");
                    String newComment = scanner.nextLine();

                    Rating updatedRating = new Rating(newStars, newComment, client.getEmail(), restUpdate);
                    RatingService.getInstance().update(updatedRating);
                    System.out.println("Rating actualizat cu succes.");
                    break;
                case "11":
                    List<Rating> myRatings = RatingService.getInstance().getByReviewerEmail(client.getEmail());
                    if (myRatings.isEmpty()) {
                        System.out.println("Nu ai lăsat niciun rating.");
                    } else {
                        for (Rating rating1 : myRatings) {
                            System.out.println("Restaurant: " + rating1.getRestaurantName() + ", Stele: " + rating1.getStars() + ", Comentariu: " + rating1.getComment());
                        }
                    }
                    break;
//                case "12":
//                    List<Rating> ratingsToDelete = RatingService.getInstance().getByReviewerEmail(client.getEmail());
//                    if (ratingsToDelete.isEmpty()) {
//                        System.out.println("Nu ai ratinguri de șters.");
//                    } else {
//                        System.out.println("Ratinguri existente:");
//                        for (Rating rating1 : ratingsToDelete) {
//                            System.out.println("ID: " + rating1.getRating_id() + " | Restaurant: " + rating1.getRestaurantName() + ", Stele: " + r.getStars() + ", Comentariu: " + r.getComment());
//                        }
//                        System.out.print("Introdu ID-ul ratingului pe care vrei să-l ștergi: ");
//                        int ratingIdToDelete = Integer.parseInt(scanner.nextLine());
//                        RatingService.getInstance().delete(ratingIdToDelete);
//                        System.out.println("Rating șters cu succes.");
//                    }
//                    break;

                case "13":
                    return;
                default:
                    System.out.println("Opțiune invalidă. Încearcă din nou.");
            }
        }
    }

    private static void driverMenu(FoodDeliveryService service, DriverService driverService, Scanner scanner) {
        System.out.print("Introdu adresa ta de email: ");
        String email = scanner.nextLine();
        Driver driver = driverService.getByEmail(email);

        if (driver == null) {
            System.out.println("Șoferul nu a fost găsit.");
            return;
        }

        while (true) {
            System.out.println("\n--- Meniu Șofer ---");
            System.out.println("1. Vizualizează informații personale");
            System.out.println("2. Modifică informații personale");
            System.out.println("3. Șterge contul");
            System.out.println("4. Înapoi la meniul principal");
            System.out.print("Alege o opțiune: ");
            String opt = scanner.nextLine();

            switch (opt) {
                case "1":
                    System.out.println("Nume: " + driver.getName());
                    System.out.println("Email: " + driver.getEmail());
                    System.out.println("Număr de înmatriculare: " + driver.getCarNumber());
                    break;
                case "2":
                    System.out.print("Nume nou: ");
                    String newName = scanner.nextLine();
                    System.out.print("Număr de înmatriculare nou: ");
                    String newCarNumber = scanner.nextLine();
                    driver.setName(newName);
                    driver.setCarNumber(newCarNumber);
                    driverService.update(driver);
                    System.out.println("Informațiile au fost actualizate.");
                    break;
                case "3":
                    System.out.print("Ești sigur că vrei să ștergi contul? (da/nu): ");
                    String confirm = scanner.nextLine();
                    if (confirm.equalsIgnoreCase("da")) {
                        driverService.deleteByEmail(email);
                        System.out.println("Contul a fost șters.");
                        return;
                    }
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Opțiune invalidă. Încearcă din nou.");
            }
        }
    }

    private static void adminMenu(FoodDeliveryService service, DriverService driverService, RestaurantService restaurantService, Scanner scanner) {

        while (true) {
            System.out.println("\n--- Meniu Admin ---");
            System.out.println("1. Adaugă un șofer - nefuncțional");
            System.out.println("2. Adaugă un restaurant");
            System.out.println("3. Modifică un restaurant");
            System.out.println("4. Vizualizează toate restaurantele");
            System.out.println("5. Șterge un restaurant");
            System.out.println("6. Afișează toți clienții");
            System.out.println("7. Afișează toți șoferii");
            System.out.println("8. Înapoi la meniul principal");
            System.out.print("Alege o opțiune: ");
            String opt = scanner.nextLine();

            switch (opt) {
                case "1":
                    System.out.print("Nume: ");
                    String driverName = scanner.nextLine();
                    System.out.print("Email: ");
                    String driverEmail = scanner.nextLine();
                    System.out.print("Număr de înmatriculare: ");
                    String carNumber = scanner.nextLine();

                    Driver newDriver = new Driver(driverName, driverEmail, carNumber);
                    driverService.create(newDriver);
                    System.out.println("Șofer adăugat cu succes.");
                    break;

                case "2":
                    System.out.print("Nume restaurant: ");
                    String restaurantName = scanner.nextLine();
                    System.out.print("Adresă restaurant: ");
                    String location = scanner.nextLine();

                    Restaurant newRestaurant = new Restaurant(restaurantName, location);
                    restaurantService.create(newRestaurant);
                    service.addRestaurant(newRestaurant);
                    AuditService.getInstance().logAction("Adaugare restaurant");
                    System.out.println("Restaurant adăugat cu succes.");
                    break;

                case "3":
                    System.out.print("Numele restaurantului de modificat: ");
                    String oldName = scanner.nextLine();
                    Restaurant existing = service.getRestaurantByName(oldName);
                    if (existing == null) {
                        System.out.println("Restaurantul nu a fost găsit.");
                        break;
                    }

                    System.out.println("Numele nu poate fi modificat. Se va actualiza doar adresa.");
                    System.out.print("Adresă nouă: ");
                    String newLoc = scanner.nextLine();

                    existing.setLocation(newLoc); // păstrează numele vechi
                    restaurantService.update(existing); // funcționează cu WHERE name = existing.getName()
                    System.out.println("Adresa restaurantului a fost actualizată.");
                    break;

                case "4":
                    Collection<Restaurant> allRestaurants = restaurantService.readAll(); // din DB
                    AuditService.getInstance().logAction("Listare restaurante");
                    if (allRestaurants.isEmpty()) {
                        System.out.println("Nu există restaurante.");
                    } else {
                        for (Restaurant r : allRestaurants) {
                            System.out.println(r.getName() + " | " + r.getLocation());
                        }
                    }
                    break;

                case "5":
                    System.out.print("Introdu numele restaurantului de șters: ");
                    String deleteName = scanner.nextLine();

                    // Verificare în baza de date
                    Collection<Restaurant> allFromDb = restaurantService.readAll();
                    Restaurant toDelete = null;
                    for (Restaurant r : allFromDb) {
                        if (r.getName().equalsIgnoreCase(deleteName)) {
                            toDelete = r;
                            break;
                        }
                    }

                    if (toDelete == null) {
                        System.out.println("Restaurantul nu a fost găsit în baza de date.");
                    } else {
                        restaurantService.deleteByName(deleteName); // ștergere din DB
                        service.getAllRestaurants().remove(toDelete); // opțional: ștergere din memorie
                        System.out.println("Restaurant șters.");
                    }
                    break;
                case "6":
                    List<Client> clienti = ClientService.getInstance().readAll();
                    AuditService.getInstance().logAction("Listare clienți");
                    System.out.println("=== Lista clienților ===");
                    for (Client c : clienti) {
                        System.out.println("Nume: " + c.getName());
                        System.out.println("Email: " + c.getEmail());
                        System.out.println("Adresa: " + c.getAddress());
                        System.out.println("------------------------");
                    }
                    break;
                case "7":
                    List<Driver> soferi = DriverService.getInstance().readAll();
                    AuditService.getInstance().logAction("Listare soferi");
                    System.out.println("=== Lista șoferilor ===");
                    for (Driver d : soferi) {
                        System.out.println("Nume: " + d.getName());
                        System.out.println("Email: " + d.getEmail());
                        System.out.println("Număr de înmatriculare: " + d.getCarNumber());
                        System.out.println("------------------------");
                    }
                    break;
                case "8":
                    return;

                default:
                    System.out.println("Opțiune invalidă.");
            }
        }
    }


}
