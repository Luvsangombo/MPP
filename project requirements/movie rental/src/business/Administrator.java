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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("%s , %s , %s", this.getFirstName(), this.getLastName(), this.getPhone());
    }
}
