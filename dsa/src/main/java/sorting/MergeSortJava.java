package sorting;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MergeSortJava {

    public static void merge(List<Integer> numbers, int start, int mid, int end) {
        List<Integer> res = new ArrayList<>();
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            if (numbers.get(i) <= numbers.get(j)) res.add(k++, numbers.get(i++));
            else res.add(k++, numbers.get(j++));
        }
        while (i <= mid) res.add(k++, numbers.get(i++));
        while (j <= end) res.add(k++, numbers.get(j++));
        for (int l = 0; l < k; l++) {
            numbers.set(start + l, res.get(l));
        }
    }

    public static void mergeSort(List<Integer> numbers, int start, int end) {
        if (end <= start) return;
        int mid = start + (end - start) / 2;
        mergeSort(numbers, start, mid);
        mergeSort(numbers, mid + 1, end);
        merge(numbers, start, mid, end);
    }

    public static void main(String[] args) {
        try (PrintWriter output = new PrintWriter(Paths.get("src/main/resources/sorting/outputMergeSort.txt").toFile())) {
            List<Integer> ints = Files.lines(Paths.get("src/main/resources/sorting/input.txt")).map(Integer::parseInt).collect(Collectors.toList());
            long startTime = System.currentTimeMillis();
            mergeSort(ints, 0, ints.size() - 1);
            System.out.println("Sorted in::" + (System.currentTimeMillis() - startTime));
            ints.forEach(output::println);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
