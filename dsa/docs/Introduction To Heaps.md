#### Indentification for when to used heaps
1) When a K is given
2) Sorting like feel

#### Types of Heap
1) Min heap
2) Max heap

#### Uses
k + largest -> min heap
k + smallest -> max heap

#### Code
1) Min heap
```java
PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
```

2) Max heap
```java
PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, Comparator.reverseOrder());
```

3) Initialize heap
```java
List<Integer> list= new ArrayList<Integer>();
for(int i = 0; i < Math.min(k, nums.length); ++i) list.add(nums[i]);
pq = new PriorityQueue<>(list);
```
Initializing complete list is important because that way, it can use heapify operations which results in O(n) time complexity.
![[Introduction To Heaps-1676301204402.jpeg]]
