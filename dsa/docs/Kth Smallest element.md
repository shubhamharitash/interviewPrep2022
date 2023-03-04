## Problem Statement
Kth Smallest element

## Approaches
#### Approach 1
Similar to [[Kth Largest element]]
Time complexity: O(nlogk) if pq is initialized else O(nlogn)

###### Code
```java
public static void main(String[] args) {  
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};  
    // capacity is not limited  
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(3, Comparator.reverseOrder());  
    Arrays.stream(arr).forEach(e -> {  
        if (priorityQueue.size() < 3) {  
            priorityQueue.add(e);  
        } else {  
            priorityQueue.add(e);  
            priorityQueue.remove();  
        }  
    });  
    System.out.println(priorityQueue.peek());  
}
```