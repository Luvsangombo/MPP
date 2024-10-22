package business;

import java.io.Serializable;
import java.util.List;

public class Movie implements Serializable {
    private static final long serialVersionUID = 1L;
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

    public String getTitle() {
        return this.title;
    }

    // Getters and Setters

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s , %s , %s , %s , %s , %s , %s", this.getTitle(), this.getGenre(), this.getFormat(),
                this.getPrice(),
                this.getQuantity(), this.getActors(), this.getDirector(), this.getAuthor());
    }
}
