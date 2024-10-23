package business;

import java.io.Serializable;

public class Author extends CrewMember implements Serializable {
    private static final long serialVersionUID = 1L;

    public Author(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public String getFullName() {
        return this.getFirstName() + "" + this.getLastName();
    }

}
