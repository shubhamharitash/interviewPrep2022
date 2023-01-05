package sorting;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class QuickSortJava {
    public static int generateRandomIndex(int start, int end) {
        return (int) (Math.random() * (end - start) + start);
    }

    public static int partition(List<Integer> numbers, int start, int end) {
        Collections.swap(numbers, end, generateRandomIndex(start, end));
        int elePivot = numbers.get(end);
        int partIndex = start;
        // partIndex will always stay stuck at element greater than it
        for (int i = start; i < end; i++) {
            if (elePivot > numbers.get(i)) {
                Collections.swap(numbers, i, partIndex++);
            }
        }
        Collections.swap(numbers, partIndex, end);
        return partIndex;
    }

    public static void quickSort(List<Integer> numbers, int start, int end) {
        if (end <= start) return;
        int pivot = partition(numbers, start, end);
        quickSort(numbers, start, pivot - 1);
        quickSort(numbers, pivot + 1, end);
    }

    public static void main(String[] args) {
        try (
                PrintWriter output = new PrintWriter(Paths.get("src/main/resources/sorting/output.txt").toFile())
        ) {
            List<Integer> ints = Files.lines(Paths.get("src/main/resources/sorting/input.txt"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            long startTime = System.currentTimeMillis();
            quickSort(ints, 0, ints.size() - 1);
            System.out.println("Sorted in::" + (System.currentTimeMillis() - startTime));
            ints.forEach(output::println);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
