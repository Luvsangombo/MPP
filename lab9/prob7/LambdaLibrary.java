import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class LambdaLibrary {

    // BiFunction for the stream pipeline
    public static final BiFunction<List<Employee>, Integer, String> EMPLOYEES_FILTER = (list, salaryLimit) -> list
            .stream()
            .filter(emp -> emp.getSalary() > salaryLimit)
            .filter(emp -> emp.getLastName().charAt(0) >= 'N')
            .map(emp -> emp.getFirstName() + " " + emp.getLastName())
            .sorted()
            .collect(Collectors.joining(", "));
}