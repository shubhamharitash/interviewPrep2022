## Problem Statement
https://www.geeksforgeeks.org/vertical-sum-in-a-given-binary-tree/

## Approaches
#### Approach 1(Using arr)
using col we addelements in array while traversing

###### Code
```java
public static void helper(Node root, int col, int[] arr){
	if(root==null)
		return;
	arr[col] += root.data;
	helper(root.left, col-1, arr);
	helper(root.right, col+1, arr);
}
public ArrayList <Integer> verticalSum(Node root) {
	int[] arr = new int[1001];
	helper(root, 500, arr);
	ArrayList<Integer> res =new ArrayList<>();
	Arrays.stream(arr).filter(e -> e!=0).forEach(res::add);
	return res;
}
```