package prob1.partB;

public class Employee {
	private String name;
	private int salary;
	
	public Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
	
	public String getName() {
		return name;
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
	public String toString() {
		return "(" + name + ", " + salary + ")";
	}
	
	// Fix: The equals method must accept Object and override the method from the Object class.
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true; 
		if(obj == null || getClass() != obj.getClass()) return false; 
		Employee e = (Employee) obj;
		return name.equals(e.name) && salary == e.salary;
	}
	
	// Fix: Implementing hashCode for consistency with equals when used in collections.
	@Override
	public int hashCode() {
		return name.hashCode() + Integer.hashCode(salary);
	}
}
