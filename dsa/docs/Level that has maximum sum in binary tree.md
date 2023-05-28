## Problem Statement
https://www.geeksforgeeks.org/find-level-maximum-sum-binary-tree/

## Approaches
#### Approach 1
Same approach as [[Max Width]], only difference being here we keep track of sum

###### Code
```java
public int maxLevelSum(Node root) {
	// add code here.
	Queue<Node> q = new LinkedList<>();
	q.offer(root);
	q.offer(null);
	int res = Integer.MIN_VALUE;
	int cnt = 0;
	while(!q.isEmpty()){
		Node temp = q.remove();
		if(temp!=null){
			cnt+=temp.data;
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