package lab10.prob1;

import java.util.*;

public class Main {
    // Write Generic method to merge two sorted lists

    public static <T extends Comparable<? super T>> List<T> mergeSortedLists(List<T> list1,
                                                 List<T> list2) {
        List<T> result = new ArrayList<T>();

        for(T e : list1) {
            result.add(e);
        }

        for(T e : list2) {
            result.add(e);
        }

        Collections.sort(result);
        return result;
    }
   

    public static void main(String[] args) {
        // Example usage with Integers
       List<Integer> sortedList1 = Arrays.asList(1, 3, 5, 7);
        List<Integer> sortedList2 = Arrays.asList(2, 4, 6, 8);

        List<Integer> mergedIntegers = mergeSortedLists(sortedList1, sortedList2);
        System.out.println("Merged sorted integers: " + mergedIntegers);

        // Example usage with Strings
        List<String> sortedStringList1 = Arrays.asList("Apple", "Banana", "Grape");
        List<String> sortedStringList2 = Arrays.asList("Cherry", "Mango", "Peach");

        List<String> mergedStrings = mergeSortedLists(sortedStringList1, sortedStringList2);
        System.out.println("Merged sorted strings: " + mergedStrings);

        // List of Person objects (already sorted)
        List<Person> sortedPersonList1 = Arrays.asList(
                new Person("John", "Doe"),
                new Person("Jane", "Smith"),
                new Person("Emily", "White")
        );

        List<Person> sortedPersonList2 = Arrays.asList(
                new Person("Alice", "Brown"),
                new Person("Bob", "Smith"),
                new Person("Charlie", "Doe")
        );
        // Merging and sorting the lists
        List<Person> mergedPersons = mergeSortedLists(sortedPersonList1, sortedPersonList2);
        System.out.println("Merged sorted persons: " + mergedPersons);
    }
}
