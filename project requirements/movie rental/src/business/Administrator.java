package business;

import java.io.Serializable;

public class Administrator implements Serializable {
    private static final long serialVersionUID = 1L;
    private String firstName;
    private String lastName;
    private int phone;

    public Administrator(String firstName, String lastName, int phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public void addMember(MemberUser member) {
        // Logic to add a member
    }

    public void addMovie(Movie movie) {
        // Logic to add a movie
    }

    public void checkoutMovie(MemberUser member, Movie movie) {
        // Logic to checkout a movie for a member
    }

    // Getters and Setters
    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

}
