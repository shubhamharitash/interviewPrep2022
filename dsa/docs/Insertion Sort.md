## Time complexity
> Best: $\Omega(n)$ (When array is already sorted)
> Average:  $\theta(n^2)$
> Worst: $O(n^2)$ (When array is reverse sorted)

## Features
>Is Inplace? -> yes
>Can perform external sorting -> no
>Is Stable -> yes

## Code
```java
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
```

## Logic

Here, push logic is used. 
We logically make two parts of array
**eg**
For input
3 5 2 8 5 7  
while iterating we follow below steps
**3**  | **5** 2 8 5 7  
**3 5** | **2** 8 5 7
For pushing 2 to correct index, we push all elements greater than two 1 index ahead which results in
**2 3 5** | **8** 5 7

>Note: Left part always remain sorted