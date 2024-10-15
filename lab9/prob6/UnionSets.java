import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;

public class UnionSets {

    // Method to compute the union of all sets in the list
    public static Set<String> union(List<Set<String>> sets) {
        return sets.stream()
                .reduce(new HashSet<>(), (set1, set2) -> {
                    set1.addAll(set2); // Merge set2 into set1
                    return set1;
                });
    }

    // Main method to test the union function
    public static void main(String[] args) {
        List<Set<String>> sets = List.of(
                Set.of("A", "B"),
                Set.of("D"),
                Set.of("1", "3", "5"));

        Set<String> result = union(sets);
        System.out.println(result);
    }
}
