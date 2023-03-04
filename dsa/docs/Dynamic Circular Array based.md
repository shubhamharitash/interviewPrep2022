## Problem Statement
Implement a dynamic circular array based implementation of queue.

## Approaches
#### Approach 1
Every thing remains same as in [[Simple Circular Array based]] or [[Circular Array Based Deque]] for implementing queue and deque, but for making it dynamic we do the following

When array full condition is encountered.
1) Create a new array with double capacity than current
2) copy all elements from front till rear to new array(maintain a count t initialize rear later)
3) front = 0, rear = cnt-1;
4) replace old array. GC will pick and remove the old array since no variable is now pointing to it.

###### Code
```java
private boolean baseConditions(int value){
	if(isEmpty){
		front = 0;
		rear = 0;
		arr[front] = value;
		return true;
	}
	int tempArr = new int[arr.length*2];
	int cnt = 0;
	while(front != rear){
		tempArr[cnt++] = arr[front];
		front = (front + 1)%arr.length;
	}
	front = 0;
	rear = cnt;
	tempArr[rear] = value;
	arr = tempArr;
	return true;
}
```