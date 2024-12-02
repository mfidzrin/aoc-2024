import java.io.*;
import java.nio.file.*;
import java.util.stream.*;
import java.util.*;

public class Day1 {

    public static void main(String[] args) throws IOException {
        var leftSides = Files.lines(Paths.get(args[0]))
            .map(line -> line.split("   ")[0])
            .map(Integer::parseInt)
            .sorted()
            .collect(Collectors.toList());
        var rightSides = Files.lines(Paths.get(args[0]))
            .map(line -> line.split("   ")[1])
            .map(Integer::parseInt)
            .sorted()
            .collect(Collectors.toList());

        //test(leftSides, rightSides);
        testSimilarity(leftSides, rightSides);

    }

    private static void test(List<Integer> l1, List<Integer> l2) {
        int total = 0;
        for (int i=0; i < l1.size(); i++) {
            int distance = 0;
            var right = l2.get(i);
            var left = l1.get(i);
            if (right > left) {
                distance = right - left;
            } else {
                distance = left - right;
            }
            total += distance;
        }
        System.out.println(total);
    }

    private static void testSimilarity(List<Integer> leftSides, List<Integer> rightSides) {
        int total = 0;
        for (int left : leftSides) {
            var countSimilar = rightSides.stream()
                .filter(i -> i == left)
                .count();

            total += left * countSimilar;

        }
        System.out.println(total);
    }
}
