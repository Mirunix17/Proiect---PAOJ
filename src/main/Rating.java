package main;

public class Rating {
    private int rating_id;
    private int stars;
    private String comment;
    private String reviewerEmail;
    private String restaurantName;

    public Rating(int stars, String comment, String reviewerEmail, String restaurantName) {
        this.stars = stars;
        this.comment = comment;
        this.reviewerEmail = reviewerEmail;
        this.restaurantName = restaurantName;
    }

    public int getStars() { return stars; }
    public String getComment() { return comment; }
    public String getReviewerEmail() { return reviewerEmail; }
    public int getRating_id() { return rating_id; }
    public String getRestaurantName() { return restaurantName; }
}
