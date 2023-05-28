## Problem Statement
https://www.geeksforgeeks.org/given-a-binary-tree-print-all-root-to-leaf-paths/

## Approaches
#### Approach 1
Simple recursion based.

###### Code
```java
public ArrayList<ArrayList<Integer>> Paths(Node root){
	// Code here
	if(root==null)
		return new ArrayList<ArrayList<Integer>>();
	if(root.left==null && root.right==null){
		ArrayList<Integer> temp = new ArrayList<>();
		temp.add(root.data);
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		res.add(temp);
		return res;
	}
	ArrayList<ArrayList<Integer>> leftPaths= Paths(root.left);
	ArrayList<ArrayList<Integer>> rightPaths= Paths(root.right);
	ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	leftPaths.forEach(leftPath -> {
		ArrayList<Integer> temp = new ArrayList<>();
		temp.add(root.data);
		temp.addAll(leftPath);
		res.add(temp);
	});
	rightPaths.forEach(rightPath -> {
		ArrayList<Integer> temp = new ArrayList<>();
		temp.add(root.data);
		temp.addAll(rightPath);
		res.add(temp);
	});
	return res;
}
```