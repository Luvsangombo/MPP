package lab10.prob2;

import java.util.Objects;

public class Person {
	String name;
	public Person(String n) {
		name = n;
	}
	public String getName() {
		return name;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Person person = (Person) o;
		return Objects.equals(name, person.name);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(name);
	}
}
