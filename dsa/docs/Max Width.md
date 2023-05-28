## Problem Statement
https://www.geeksforgeeks.org/maximum-width-of-a-binary-tree/

## Approaches
#### Approach 1
Using level order traversal with null we count the number of nodes in that level

###### Code
```java
int getMaxWidth(Node root) {
	// Your code here
	Queue<Node> q = new LinkedList<>();
	q.offer(root);
	q.offer(null);
	int res = 0;
	int cnt = 0;
	while(!q.isEmpty()){
		Node temp = q.remove();
		if(temp!=null){
			cnt++;
		} else {
			res = Math.max(res, cnt);
			cnt = 0;
			if(!q.isEmpty())
				q.offer(null);
			continue;
		}
		if(temp.left!=null)
			q.offer(temp.left);
		if(temp.right!=null)
			q.offer(temp.right);
	}
	return res;
}
```