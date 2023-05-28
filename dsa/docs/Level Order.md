## Problem Statement
![[Level Order-1678014970398.jpeg]]

## Approaches
#### Approach 1
Queue will help us here.

###### Code
```java
static ArrayList<Integer> levelOrder(Node node) {
	ArrayList<Integer> res = new ArrayList<>();
	Queue<Node> queue = new LinkedList<>();
	queue.add(node);
	while (!queue.isEmpty()) {
		Node temp = queue.remove();
		res.add(temp.data);
		if (temp.left != null)
			queue.add(temp.left);
		if (temp.right != null)
			queue.add(temp.right);
	}
	return res;
}
```