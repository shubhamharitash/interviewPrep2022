## Problem Statement
https://www.geeksforgeeks.org/find-the-maximum-depth-or-height-of-a-tree/

## Approaches
#### Approach 1(Recursive)
By definition

###### Code
```java
int height(Node root) 
{
	if(root==null)
		return 0;
	return 1 + Math.max(height(root.left), height(root.right));
}
```

#### Approach 2(Using Level Order Traversal)
![[Height of Binary Tree-1678044321766.jpeg]]

###### Code
```java
int height(Node node){
	Queue<Node> queue = new LinkedList<>();
	queue.add(node);
	queue.add(null);
	int cnt = 0;
	while (!queue.isEmpty()) {
		Node temp = queue.remove();
		if(temp == null){
			cnt++;
			if(!queue.isEmpty())
				queue.add(null);
			continue;
		}
		if (temp.left != null)
			queue.add(temp.left);
		if (temp.right != null)
			queue.add(temp.right);
	}
	return cnt;
}
```