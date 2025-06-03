package main;

public abstract class User {
    protected String name;
    protected String email;
    protected Integer user_id;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }

    public Integer getId() { return user_id; }

    public void setId(int id) {
        this.user_id = user_id;
    }
}
