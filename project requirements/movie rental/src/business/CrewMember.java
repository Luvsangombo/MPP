package business;

import java.io.Serializable;

public class CrewMember implements Serializable {
    private static final long serialVersionUID = 1L;
    private String firstName;
    private String lastName;

    public CrewMember(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters and Setters

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

}
