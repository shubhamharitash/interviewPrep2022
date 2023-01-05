## Time Complexity
> Best: $\Omega(n^2)$
> Average:  $\theta(n^2)$
> Worst: $O(n^2)$ 

## Features
>Is Inplace? -> yes
>Can perform external sorting -> no
>Is Stable -> yes

## Code
```java
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
```