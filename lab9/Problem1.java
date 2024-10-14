package lesson9.lab9;

import java.util.*;

public class Problem1 {
    public static void main(String[] args) {
        List<String> listWords = new ArrayList<String>();
        listWords.add("hello");
        listWords.add("worhd");
        listWords.add("this");
        listWords.add("is");
        listWords.add("MPP");
        listWords.add("class");

        System.out.print(countWords(listWords, 'h', 'c', 5)); // hello, worhd
    }
    static int countWords(List<String> words, char c, char d, int len) {
        Long wordCount = words.stream()
                .filter(x -> x.length() == len)
                .filter(x -> x.contains(String.valueOf(c)))
                .filter(x -> !x.contains(String.valueOf(d)))
                .count();
        return wordCount.intValue();
    }
}
