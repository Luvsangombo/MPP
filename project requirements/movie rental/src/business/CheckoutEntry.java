package business;

import java.io.Serializable;
import java.time.LocalDate;

public class CheckoutEntry implements Serializable {
    private static final long serialVersionUID = 1L;
    private Movie movie;
    private LocalDate checkoutDate;
    private LocalDate dueDate;

    public CheckoutEntry(Movie movie, LocalDate checkoutDate, LocalDate dueDate) {
        this.movie = movie;
        this.checkoutDate = checkoutDate;
        this.dueDate = dueDate;
    }

    public String getMovieTitle() {
        return this.movie.getTitle();
    }

    // Getters and Setters
    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(LocalDate checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
