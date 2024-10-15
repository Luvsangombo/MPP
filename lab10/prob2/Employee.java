package lab10.prob2;

import java.util.Objects;

public class Employee extends Person {
	int id;
	int salary;
	
	public Employee(int id, String n, int s) {
		super(n);
		this.id = id;
		this.salary = s;
		
	}
	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("<");
		sb.append("name: ");
		sb.append(getName());
		sb.append(" salary: ");
		sb.append("" + salary);
		sb.append(" year of birth: ");
		return sb.toString();
		
	}


	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public int hashCode(){
		return Objects.hash(this.id, this.salary, getName());
	}

	@Override
	public boolean equals(Object o) {
		return super.equals(o) && this.id == ((Employee) o).id && this.salary == ((Employee) o).salary;
	}
}

