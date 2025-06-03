package main;

//public class Client extends User {
//    private String address;
//
//    public Client(String name, String email, String address) {
//        super(name, email);
//        this.address = address;
//    }
//
//    public String getAddress() { return address; }
//}

public class Client extends User {
    private String address;

    public Client(String name, String email, String address) {
        super(name, email);
        this.address = address;
    }

    public String getAddress() { return address; }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String newName) {
        this.name = newName;
    }
}