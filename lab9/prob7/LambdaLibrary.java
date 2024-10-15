package lesson9.lab9.prob7;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

@FunctionalInterface
interface TriFunction<S, U, R, T> {
    T apply(S s, U u, R r);
}

public class LambdaLibrary {
    public static final TriFunction<List<Employee>, Integer, Character, String> FILTER = (list, salary, c) -> {
                return list.stream().filter(x -> x.getSalary() > salary)
                        .filter(x -> x.getLastName().charAt(0) >= c)
                        .map(x-> x.getFirstName() + " " + x.getLastName())
                        .sorted()
                        .collect(Collectors.joining(", "));
            };
}
