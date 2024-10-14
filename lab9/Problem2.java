package lesson9.lab9;

import java.util.stream.IntStream;

public class Problem2 {
    public static void main(String[] args) {
        printSquares(4);
    }
    public static void printSquares(int num) {
        IntStream.iterate(1, i -> i + 1)
                .limit(num)
                .map(x -> x * x)
                .forEach(System.out::println);
    }
}
