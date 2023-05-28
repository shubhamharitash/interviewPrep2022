## Problem Statement
Search an element in binary tree

## Approaches
#### Approach 1
Simply perform any traversal and find the result

###### Code
```java
public static boolean searchNodeInBT(Node root, int data){
	if(root==null)
		return false;
	if(root.data == data)
		return true;
	return searchNodeInBT(root.left, data) || searchNodeInBT(root.right, data);
}
```

#### Approach 2(Iterative)
Simply to level order traversal or any of the iterative versions of pre, post or inorder traversals
