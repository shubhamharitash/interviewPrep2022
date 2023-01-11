package searching.binarySearch.theory;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Q3_OrderAgnosticSearch {
    public static void main(String[] args) {
        List<Integer> nums = IntStream.iterate(1, i -> i + 1).limit(100).boxed().collect(Collectors.toList());
        if(nums.get(0) < nums.get(1))
            System.out.println(Collections.binarySearch(nums, 30));
        else
            System.out.println(Collections.binarySearch(nums, 30, Comparator.reverseOrder()));
    }
}
