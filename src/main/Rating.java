package main;

public class Rating {
    private int stars;
    private String comment;
    private String reviewerEmail;

    public Rating(int stars, String comment, String reviewerEmail) {
        this.stars = stars;
        this.comment = comment;
        this.reviewerEmail = reviewerEmail;
    }

    public int getStars() { return stars; }
    public String getComment() { return comment; }
    public String getReviewerEmail() { return reviewerEmail; }
}
