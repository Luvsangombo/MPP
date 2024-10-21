package business;

import java.io.Serializable;

public class MemberUser implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String firstName;
    private String lastName;
    private int phone;
    private String address;
    private Administrator createdBy;

    public MemberUser(int id, String firstName, String lastName, int phone, String address, Administrator createdBy) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
        this.createdBy = createdBy;
    }

    public void requestMovie(Movie movie) {
        // Logic to request a movie
    }

    public String getFullName() {
        return this.firstName + "" + this.lastName;
    }

    // Getters and Setters
    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Administrator getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Administrator createdBy) {
        this.createdBy = createdBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
