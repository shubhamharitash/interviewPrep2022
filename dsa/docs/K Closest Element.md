## Problem Statement
![[K Closest Element-1676191586164.jpeg]]
## Approaches
#### Approach 1
Here we are simply performing comparision on a - x.
So we use as comparingInt chain to provide comparing logic.

###### Code
```java
public List<Integer> findClosestElements(int[] arr, int k, int x) {
	Comparator<Integer> comp = Comparator.comparingInt((Integer a) -> Math.abs(a - x)).thenComparingInt(a -> a);
	List<Integer> input = Arrays.stream(arr).boxed().collect(Collectors.toList());
	PriorityQueue<Integer> pq = new PriorityQueue<>(comp);
	pq.addAll(input);
	List<Integer> res = new ArrayList<>();
	for (int i = 0; i < k; i++) {
		res.add(pq.remove());
	}
	Collections.sort(res);
	return res;
}
```