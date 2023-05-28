## Problem Statement
https://www.geeksforgeeks.org/check-if-two-trees-are-mirror/

## Approaches
#### Approach 1(Recursive)
Perform recursive call with two params

###### Code
```java
public static boolean checkIfMirror(Node root1, Node root2){
	if(root1==null && root2==null)
		return true;
	if(root1==null || root2==null || root1.data!=root2.data)
		return false;
	return checkIfMirror(root1.left, root2.right) || checkIfMirror(root1.right, root2.left);
}
```