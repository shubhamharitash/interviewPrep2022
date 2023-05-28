## Problem Statement
https://practice.geeksforgeeks.org/problems/max-and-min-element-in-binary-tree/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

## Approaches
#### Approach 1(Recursion)
perform any traversal and maintain the max;

###### Code
```java
public static int findMax(Node root){
	if(root == null)
		return Integer.MIN_VALUE;
	int ans1 = findMax(root.left);
	int ans2 = findMax(root.right);
	return Math.max(root.data, Math.max(ans1, ans2));
}
public static int findMin(Node root){
	if(root == null)
		return Integer.MAX_VALUE;
	int ans1 = findMin(root.left);
	int ans2 = findMin(root.right);
	return Math.min(root.data, Math.min(ans1, ans2));
}
```

#### Approach 2(Without Recursion)
We can use level order traversal or iterative versions of pre, post, inorder traversals.