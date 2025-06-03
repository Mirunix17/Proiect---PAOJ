package main;

import java.util.*;

public class Restaurant {
    private String name;
    private String location;
    private List<MenuItem> menu;
    private List<Rating> ratings = new ArrayList<>();

    public Restaurant(String name, String location) {
        this.name = name;
        this.location = location;
        this.menu = new ArrayList<>();
    }

    public String getName() { return name; }
    public String getLocation() { return location; }
    public List<MenuItem> getMenu() { return menu; }

    public void addRating(Rating rating) {
        ratings.add(rating);
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public double getAverageRating() {
        return ratings.stream()
                .mapToInt(Rating::getStars)
                .average()
                .orElse(0.0);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void addItem(MenuItem item) {
        menu.add(item);
    }

}
