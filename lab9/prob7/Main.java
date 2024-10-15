package lesson9.lab9.prob7;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<Employee> list = Arrays.asList(new Employee("Joe", "Davis", 120000),
				          new Employee("John", "Sims", 110000),
				          new Employee("Joe", "Stevens", 200000),
		                  new Employee("Andrew", "Reardon", 80000),
		                  new Employee("Joe", "Cummings", 760000),
		                  new Employee("Steven", "Walters", 135000),
		                  new Employee("Thomas", "Blake", 111000),
		                  new Employee("Alice", "Richards", 101000),
		                  new Employee("Donald", "Trump", 100000));

		//your stream pipeline here
		String result = list.stream()
					.filter(x -> x.getSalary() > 100000)
					.filter(x -> x.getLastName().charAt(0) >= 'N')
					.map(x-> x.getFirstName() + " " + x.getLastName())
					.sorted()
					.collect(Collectors.joining(", "));
		System.out.println(result);
		String result2 = LambdaLibrary.FILTER.apply(list, 100000, 'N');
		System.out.println(result2);
	}

}
