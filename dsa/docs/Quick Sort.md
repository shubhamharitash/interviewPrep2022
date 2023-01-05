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

## Logic
1.  An array is divided into subarrays by selecting a **pivot element** (element selected from the array).  
      
    While dividing the array, the pivot element should be positioned in such a way that elements less than pivot are kept on the left side and elements greater than pivot are on the right side of the pivot.
2.  The left and right subarrays are also divided using the same approach. This process continues until each subarray contains a single element.
3.  At this point, elements are already sorted. Finally, elements are combined to form a sorted array.

#### Push logic in partition
The elements required to the left are always swapped with partition index
comparision is performed for whether current is on left
	if true it is swapped with ele at part_index since it always points to element at right
partition_index stays stuck at elements required on right(if there is a element for right)
