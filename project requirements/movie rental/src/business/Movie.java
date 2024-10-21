package business;

import java.util.List;

public class Movie {
    private String title;
    private String format;
    private String genre;
    private Author author;
    private List<Actor> actors;
    private Director director;
    private int quantity;
    private double price;
    private boolean availability;

    public Movie(String title, String format, String genre, Author author, List<Actor> actors, Director director,
            int quantity, double price) {
        this.title = title;
        this.format = format;
        this.genre = genre;
        this.author = author;
        this.actors = actors;
        this.director = director;
        this.quantity = quantity;
        this.price = price;
        this.availability = (quantity > 0);
    }

    public boolean isAvailable() {
        return availability;
    }

    // Getters and Setters
}
