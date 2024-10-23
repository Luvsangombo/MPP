package business;

import java.io.Serializable;

public class Director extends CrewMember implements Serializable {
    private static final long serialVersionUID = 1L;

    public Director(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public String getFullName() {
        return this.getFirstName() + "" + this.getLastName();
    }

    @Override
    public String toString() {
        return String.format("%s , %s ", this.getFirstName(), this.getLastName());
    }
}
