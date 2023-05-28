## Time complexity
> Best: $\Omega(nlog(n))$ 
> Average:  $\theta(nlog(n))$
> Worst: $O(n^2)$ (When array is reverse sorted)(Can be avoided with randomized quicksort)

## Features
>Is Inplace? -> no
>Can perform external sorting -> no
>Is Stable -> no(can be made stable using some code changes)

## Code
```java
public static int generateRandomIndex(int start, int end) {  
    return (int) (Math.random() * (end - start) + start);  
}  
  
public static int partition(List<Integer> numbers, int start, int end) {  
    // we need to use end since we want correct element at partIndex
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
    if (end < start)  
        return;  
    int pivot = partition(numbers, start, end);  
    quickSort(numbers, start, pivot - 1);  
    quickSort(numbers, pivot + 1, end);  
}
```

Using Array
```java
import java.util.*;
class Solution {
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static int generateRandomIndex(int start, int end) {  
        return (int) (Math.random() * (end - start) + start); 
    }  
    public static int partition(int[] nums, int start, int end){
        int pivot_index = generateRandomIndex(start, end);
        swap(nums, pivot_index, end);
        int elePivot = nums[end];
        int ptr = start;
        for(int i = start; i<=end; i++){
            if(nums[i] < elePivot){
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ptr++;
            }
        }
        swap(nums, ptr, end);
        return ptr;
    }
    public static void quickSort(int[] nums, int start, int end){
        if(start>end){
            return;
        }
        int pivot = partition(nums, start, end);
        quickSort(nums, start, pivot - 1);
        quickSort(nums, pivot + 1, end);
    }
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
}
```

## Logic
![[Quick Sort-1684596242044.jpeg]]

#### Push logic in partition```java

```
The elements required to the left are always swapped with partition index
comparision is performed for whether current is on left
	if true it is swapped with ele at part_index since it always points to element at right
partition_index stays stuck at elements required on right(if there is a element for right)
