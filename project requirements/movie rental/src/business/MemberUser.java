package business;

import java.io.Serializable;

public class MemberUser implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private Administrator createdBy;

    public MemberUser(int id, String firstName, String lastName, String phone, String address, Administrator createdBy) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
        this.createdBy = createdBy;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null) return false;
        if(!(obj instanceof MemberUser)) return false;

        MemberUser other = (MemberUser) obj;

        return firstName.equals(other.getFirstName()) && lastName.equals(other.getLastName()) && id==other.getId();
    }

    public void requestMovie(Movie movie) {
        // Logic to request a movie
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    // Getters and Setters
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
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

    @Override
    public String toString() {
        return String.format("%s , %s , %s , %s", this.getFirstName(), this.getLastName(), this.getPhone(),
                this.getAddress());
    }
}
