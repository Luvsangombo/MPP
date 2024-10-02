package lab3.prob1;

public class PersonWithJob {
	private Person p;
	private double salary;
	
	public double getSalary() {
		return salary;
	}
	PersonWithJob(Double s, Person p) {
		this.p = p;
		this.salary = s;
	}
	
	@Override
	public boolean equals(Object aPersonWithJob) {
		if(aPersonWithJob == null) return false; 
		if(!(aPersonWithJob instanceof PersonWithJob)) return false;
		PersonWithJob withJob = (PersonWithJob)aPersonWithJob;
		boolean isEqual = this.p.equals(withJob.p) &&
                (this.getSalary() == withJob.getSalary());
		return isEqual;
	}
	public static void main(String[] args) {
		Person p2 = new Person("Joe");
		PersonWithJob p1 = new PersonWithJob(3000.0, p2);

		//As PersonsWithJobs, p1 should be equal to p2
		System.out.println("p1.equals(p2)? " + p1.equals(p2));
		System.out.println("p2.equals(p1)? " + p2.equals(p1));
	}


}
