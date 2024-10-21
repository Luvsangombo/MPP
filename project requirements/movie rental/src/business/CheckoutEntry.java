package business;

import java.time.LocalDate;

public class CheckoutEntry {
    private Movie movie;
    private LocalDate checkoutDate;
    private LocalDate dueDate;

    public CheckoutEntry(Movie movie, LocalDate checkoutDate, LocalDate dueDate) {
        this.movie = movie;
        this.checkoutDate = checkoutDate;
        this.dueDate = dueDate;
    }

    // Getters and Setters
}
