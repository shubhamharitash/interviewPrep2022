## Problem Statement
https://practice.geeksforgeeks.org/problems/nearly-sorted-1587115620/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

## Approaches
#### Approach 1
![[Sort a K sorted array-1676189192916.jpeg]]

###### Code
```java
public static ArrayList<Integer> nearlySorted(int arr[], int num, int k) {  
    // your code here  
    ArrayList<Integer> res = new ArrayList<>();  
    List<Integer> input = new ArrayList<>();  
    for (int i = 0; i <= k; i++) {  
        input.add(arr[i]);  
    }  
    PriorityQueue<Integer> pq = new PriorityQueue<>(input);  
    res.add(pq.remove());  
    for (int i = 1; i < arr.length - k; i++) {  
        pq.add(arr[i + k]);  
        res.add(pq.remove());  
    }  
    while (!pq.isEmpty()) {  
        res.add(pq.remove());  
    }  
    return res;  
}
```