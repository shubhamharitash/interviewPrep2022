## Problem Statement
https://leetcode.com/problems/kth-largest-element-in-a-stream/description/

## Approaches
#### Approach 1
1) Create a minHeap of Capacity k.
2) If size < capacity add element to heap
3) else add and then pop the element.

###### Code
```java
PriorityQueue<Integer> pq;
int k;
public KthLargest(int k, int[] nums) {
	this.k = k;
	pq = new PriorityQueue<>();
	Arrays.stream(nums).forEach(e -> {
		if(pq.size()<k){
			pq.add(e);
		} else {
			pq.add(e);
			pq.remove();
		}
	});
}

public int add(int val) {
	if(pq.size()<k){
		pq.add(val);
	} else {
		pq.add(val);
		pq.remove();
	}
	return pq.peek();
}
```