package prob1.partB;

import java.util.ArrayList;
import java.util.List;

public class EmployeeInfo {

	/**
	 * Removes all duplicate Employee instances from input list (only a copy is
	 * modified)
	 * An Employee instance is considered to be a duplicate of another Employee
	 * instance if the two instances have the same name and salary.
	 */
	public static List<Employee> removeDuplicates(List<Employee> employees) {
		List<Employee> noDupsList = new ArrayList<>();
		// Fix: Avoid assuming the first element is always present.
		if (employees.size() > 0) {
			noDupsList.add(employees.get(0));
		}
		for (int i = 1; i < employees.size(); ++i) {
			if (!inList(employees.get(i), noDupsList)) {
				noDupsList.add(employees.get(i));
			}
		}
		return noDupsList;
	}

	/** Returns true if e is in the list emps, false otherwise */
	private static boolean inList(Employee e, List<Employee> emps) {
		// Fix: Using the corrected equals method and hashCode
		for (Employee emp : emps) {
			if (e.equals(emp))
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		List<Employee> list = new ArrayList<Employee>() {
			{
				add(new Employee("Richard", 55000));
				add(new Employee("Richard", 55000));
				add(new Employee("John", 30000));
				add(new Employee("Steve", 30000));
				// more employees...
			}
		};

		List<Employee> dupsRemoved = new ArrayList<Employee>() {
			{
				add(new Employee("Richard", 55000));
				add(new Employee("John", 30000));
				add(new Employee("Steve", 30000));
				// more employees...
			}
		};

		List<Employee> answer = removeDuplicates(list);
		System.out.println("Is answer correct? " + listsAreEqual(answer, dupsRemoved));
	}

	public static boolean listsAreEqual(List<Employee> l1, List<Employee> l2) {
		if (l1.size() != l2.size())
			return false;
		for (Employee e : l1) {
			if (!l2.contains(e))
				return false;
		}
		return true;
	}
}
