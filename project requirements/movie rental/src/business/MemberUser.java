package business;

public class MemberUser {
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

    // Getters and Setters
}
