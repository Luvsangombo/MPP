import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.joining;

import java.util.Arrays;
import java.util.List;

public class PuttingIntoPractice {
    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950));

        // Query 1: Find all transactions from year 2011 and sort them by value (small
        // to high).
        List<Transaction> trans2011 = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .collect(toList());
        System.out.println("Transactions from 2011 sorted by value: " + trans2011);

        // Query 2: What are all the unique cities where the traders work?
        List<String> uniqueCities = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(toList());
        System.out.println("Unique cities where traders work: " + uniqueCities);

        // Query 3: Find all traders from Cambridge and sort them by name.
        List<Trader> tradersFromCambridge = transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> "Cambridge".equals(t.getCity()))
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(toList());
        System.out.println("Traders from Cambridge sorted by name: " + tradersFromCambridge);

        // Query 4: Return a string of all traders names sorted alphabetically.
        String traderNames = transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .collect(joining(", "));
        System.out.println("All trader names sorted alphabetically: " + traderNames);

        // Query 5: Are there any trader based in Milan?
        boolean anyTraderInMilan = transactions.stream()
                .anyMatch(t -> "Milan".equals(t.getTrader().getCity()));
        System.out.println("Any trader based in Milan? " + anyTraderInMilan);

        // Query 6: Update all transactions so that the traders from Milan are set to
        // Cambridge.
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> "Milan".equals(t.getCity()))
                .forEach(t -> t.setCity("Cambridge"));
        System.out.println("Updated transactions after changing Milan traders to Cambridge: " + transactions);

        // Query 7: What's the highest value in all the transactions?
        int highestValue = transactions.stream()
                .map(Transaction::getValue)
                .max(Integer::compare)
                .orElse(0);
        System.out.println("The highest value in all the transactions: " + highestValue);
    }
}