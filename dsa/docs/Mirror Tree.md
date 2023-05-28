## Problem Statement
https://www.geeksforgeeks.org/write-an-efficient-c-function-to-convert-a-tree-into-its-mirror-tree/

## Approaches
#### Approach 1(Level order traversal)
![[Mirror Tree-1678220374351.jpeg]]
2nd queue is not needed, one q works

###### Code
```java
void mirror(Node root) {
	// Your code here
	Queue<Node> q = new LinkedList<>();
	q.offer(root);
	while(!q.isEmpty()){
		Node temp = q.poll();
		if(temp.left!=null)
			q.offer(temp.left);
		if(temp.right!=null)
			q.offer(temp.right);
		Node temp2 = temp.left;
		temp.left = temp.right;
		temp.right = temp2;
	}
}
```

#### Approach 2(Recursive)
Simple recursion

###### Code
```java
class Solution {
    // Function to convert a binary tree into its mirror tree.
    public static Node helper(Node root){
        if(root==null)
            return root;
        Node temp = root.left;
        root.left = helper(root.right);
        root.right = helper(temp);
        return root;
    }
    void mirror(Node node) {
        helper(node);
    }
}
```