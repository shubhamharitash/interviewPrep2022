package sorting;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BubbleSortJava {
    public static void bubbleSort(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            boolean swapped = false;
            for (int j = 0; j < numbers.size() - 1 - i; j++) {
                if (numbers.get(j) > numbers.get(j + 1)){
                    swapped = true;
                    Collections.swap(numbers, j, j+1);
                }
            }
            if(!swapped)
                break;
        }
    }
    public static void main(String[] args) {
        List<Integer> numbers = IntStream.range(0, 100).boxed().collect(Collectors.toList());
        Collections.shuffle(numbers);
        System.out.println(numbers);
        bubbleSort(numbers);
        System.out.println(numbers);
    }
}
