package sorting.algorithms;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SelectionSortJava {
    public static void selectionSort(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            int mini = i;
            for (int j = i + 1; j < numbers.size(); j++) {
                if(numbers.get(j) < numbers.get(mini)){
                    mini = j;
                }
            }
            Collections.swap(numbers, i, mini);
        }
    }

    public static void main(String[] args) {
        List<Integer> numbers = IntStream.range(0, 100).boxed().collect(Collectors.toList());
        Collections.shuffle(numbers);
        System.out.println(numbers);
        selectionSort(numbers);
        System.out.println(numbers);
    }
}
