package business;

import java.io.Serializable;

public class Actor extends CrewMember implements Serializable {
    private static final long serialVersionUID = 1L;

    public Actor(String firstName, String lastName, String bio) {
        super(firstName, lastName, bio);
    }

    public String getFullName() {
        return this.getFirstName() + "" + this.getLastName();
    }

}
