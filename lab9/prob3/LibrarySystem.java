package lesson9.lab9.prob3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LibrarySystem {
    public static void main(String[] args) {

        // Created libraries

        Library library1 = new Library("City Library", List.of("Origin", "Inferno", "Dune", "Foundation"));
        Library library2 = new Library("Town Library", List.of("Twilight", "Outliers"));
        Library library3 = new Library("Village Library", List.of("Becoming", "Leadership", "Creativity", "Sapiens", "Rebecca"));

        // Task 1. Create a list of libraries from the given three Library objects
        List<Library> libraries = Stream.of(library1, library2, library3)
                                        .collect(Collectors.toList());

        // Task 2: Filter libraries that have more than 3 books and print the name of the Library
        System.out.println("************ Task 2 ************ ");
        libraries.stream()
                .filter(l -> l.getBooks().size() > 3)
                .map(Library::getName)
                .forEach(System.out::println);

        // Task 3: FlatMap to get all the book titles from the libraries and print the results on the console
        System.out.println("************ Task 3 ************ ");
        libraries.stream()
                .flatMap(l -> Stream.of(l.getName(), l.getBooks()))
                .forEach(System.out::println);
    }
}
