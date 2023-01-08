[Link](https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/)

## Approaches
#### Approach 1
1) push 0s to left, 1s and 2s to right.
2) push 0s and 1s to left, 2s to right.

0 0 0 0 2 1 2 2 2 2 1 1 2 2
```java
part_index = 0;
for(int i=0; i< arr.length; i++) {
	if(0 >= arr[i]){
		int temp = arr[i];
		arr[i] = arr[part_index];
		arr[part_index] = temp;
		part_index++;
	}
}
part_index = 0;
for(int i=0; i< arr.length; i++) {
	if(1 >= arr[i]){
		int temp = arr[i];
		arr[i] = arr[part_index];
		arr[part_index] = temp;
		part_index++;
	}
}
```