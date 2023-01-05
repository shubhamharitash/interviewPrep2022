## Time complexity
> Best: $\Omega(n)$ (When array is already sorted)
> Average:  $\theta(n)$
> Worst: $O(n^2)$ (When array is reverse sorted)

## Features
>Is Inplace? -> yes
>Can perform external sorting -> no
>Is Stable -> yes

## Code
```java
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
```

## Logic
On each iteration in inner loop, two elements are compared and smaller one is pushed to top
Thus we need only **n-1-i** iterations in inner loop, we can break from loop if no swaps are performed in the loop