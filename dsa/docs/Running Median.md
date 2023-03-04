## Problem Statement
https://leetcode.com/problems/find-median-from-data-stream/description/

## Approaches
#### Approach 1
The idea here is to always keep 
1) top of maxHeap < top of minHeap
2) smaller elements in maxHeap and bigger elements in minHeap

This translates to 2 conditions for both of the below cases
1) when size is equal.
2) when size is not equal.

###### Code
```java
class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap; 

    public MedianFinder() {
        maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
        minHeap = new PriorityQueue<Integer>(); 
    }
    
    public void addNum(int num) {
        if(maxHeap.size() == minHeap.size()){
            if(maxHeap.size() == 0){
                maxHeap.add(num);
                return;
            }
            if(num > minHeap.peek()){
                maxHeap.add(minHeap.remove());
                minHeap.add(num);
            } else {
                maxHeap.add(num);
            }
        } else {
            if(num > maxHeap.peek()){
                minHeap.add(num);
            } else {
                minHeap.add(maxHeap.remove());
                maxHeap.add(num);
            }
        }
    }
    
    public double findMedian() {
        if(maxHeap.size() == minHeap.size())
            return (double)(maxHeap.peek() + minHeap.peek())/2;
        return maxHeap.peek();
    }
}
```