## Problem Statement

## Approaches(Recursion)
#### Approach 1
Simply apply any traversal

###### Code
```java
public static int countLeaf(Node root){
	if(rooot==null)
		return 0;
	if(root.left==null && root.right==null)
		return 1;
	return countLeaf(root.left) + countLeaf(root.right);
}
```

#### Approach 2
Simply perform level order traversal and check of required nodes.

###### Code
```java
```