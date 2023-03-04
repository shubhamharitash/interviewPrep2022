#### Q: What is a Heap?
It is an ADT which whenever asked, provides us with the highest priority element.

#### Types of heaps
1) Max heap
Always has maximum element at its top
![[Basics Of Heaps-1676129320903.jpeg]]
2) Min heap
Always has minimum element at its top
![[Basics Of Heaps-1676129330246.jpeg]]

#### Representation of Heaps in Array
![[Basics Of Heaps-1676130180174.jpeg]]

#### Heapify
![[Basics Of Heaps-1676130210952.jpeg]]

![[Basics Of Heaps-1676130229418.jpeg]]

```java
public static void maxHeapify(int[] arr, int index){
	int leftChild = 2*index + 1;
	int rightChild = 2*index + 2;
	int largest = index;
	if(leftChild < arr.length && arr[leftChild] > arr[largest]){
		largest = leftChild;
	}
	if(rightChild < arr.length && arr[rightChild] > arr[largest]){
		largest = rightChild;
	}
	if(largest!=index){
		// swap largest and index
		int temp = arr[index];
		arr[index] = arr[largest];
		arr[largest] = arr[index];
		// heapify childnode
		maxHeapify(arr, largest);
	}
}
```
Time complexity: O(n)

#### Creating a heap
![[Basics Of Heaps-1676131024753.jpeg]]
```java
public static void createHeap(int arr){
	for(int i=n/2-1; i>=0; i++){
		maxHeapify(arr, i);
	}
}
```

>Time complexity: O(n) 😈

###### Q: How time complexity is O(n)
-> Time taken by each heapify operation == **O(h)** where **h** is the height of the tree
for all nodes in range n/2...0 index, sum of heights $\sim$  n 
$\therefore$ Time complexity: O(n)

#### Insert in heap
![[Basics Of Heaps-1676131910986.jpeg]]
```java
public static void insertHeap(int[] arr, int ele, int n){
	arr[n] = ele;
	int index = n;
	while(index > 0){
		int parent = (i-1)/2;
		if(arr[parent] < arr[index]){
			int temp = arr[parent];
			arr[parent] = arr[index];
			arr[index] = temp;
		} else {
			break;
		}
		index = parent;
	}
}
```

#### Delete Heap
Here we swap last and first element(leaf and root nodes), perform heapify operation again
```java
public int void deleteHeap(int arr){
	int n = arr.length;
	if(n==0)
		return -1;
	int ans = arr[0];
	int temp = arr[0];
	arr[0] = arr[n-1];
	arr[n-1] = temp;
	maxHeapify(arr, 0);
}
```

#### HeapSort
Simply keep on popping elements from heap
for ascending create minHeap
for descending create maxheap
```java
public static void heapSort(int[] arr, int n){
	for(int i=0; i<n-1;i++){
		System.out.println(deleteHeap(arr));
	}
}
```
