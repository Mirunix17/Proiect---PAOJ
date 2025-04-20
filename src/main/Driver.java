package main;

public class Driver extends User {
    private String carNumber;

    public Driver(String name, String email, String carNumber) {
        super(name, email);
        this.carNumber = carNumber;
    }

    public String getCarNumber() { return carNumber; }
}
