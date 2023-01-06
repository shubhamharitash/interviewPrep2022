package sorting.algorithms;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InsertionSortJava {
    public static void insertionSort(List<Integer> numbers) {
        for (int i = 1; i < numbers.size(); i++) {
            int cur_ele = numbers.get(i);
            int j = i - 1;
            while (j >= 0 && numbers.get(j) > cur_ele) {
                numbers.set(j + 1, numbers.get(j));
                j--;
            }
            numbers.set(j+1, cur_ele);
        }
    }

    public static void main(String[] args) {
        List<Integer> numbers = IntStream.range(0, 100).boxed().collect(Collectors.toList());
        Collections.shuffle(numbers);
        System.out.println(numbers);
        insertionSort(numbers);
        System.out.println(numbers);
    }
}
