## Time complexity
> Best: $\Omega(nlog(n))$ 
> Average:  $\theta(nlog(n))$
> Worst: $O(nlog(n))$

## Features
>Is Inplace? -> no
>Can perform external sorting -> yes
>Is Stable -> yes
>Can also sort LinkedLists

## Code
```java
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
```

