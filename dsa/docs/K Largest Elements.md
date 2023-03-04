## Problem Statement
https://practice.geeksforgeeks.org/problems/k-largest-elements4206/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

## Approaches
#### Approach 1
Form a min heap, remove all larger elements by popping till it remains of k size.

###### Code
```java
public static int[] kLargest(int[] arr, int n, int k) {  
    //min-heap  
    PriorityQueue<Integer> pq = Arrays.stream(arr).boxed().collect(Collectors.toCollection(PriorityQueue::new));  
    while (pq.size() > k) {  
        pq.remove();  
    }  
    int[] res = new int[k];  
    for (int i = k-1; i >= 0; i++) {  
        res[i] = pq.remove();  
    }  
    return res;  
}
```