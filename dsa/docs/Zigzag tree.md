## Problem Statement
https://www.geeksforgeeks.org/zigzag-tree-traversal/

## Approaches
#### Approach 1
We use two stacks to alternate traversal direction
![[Zigzag tree-1678281263461.jpeg]]

###### Code
```java
class GFG
{
    //Function to store the zig zag order traversal of tree in a list.
	ArrayList<Integer> zigZagTraversal(Node root)
	{
	    Stack<Node> s1 = new Stack<>();
	    Stack<Node> s2 = new Stack<>();
	    ArrayList<Integer> res = new ArrayList<>();
	    s1.push(root);
	    while(!s1.isEmpty() || !s2.isEmpty()){
	        while(!s1.isEmpty()){
	            Node temp = s1.pop();
	            res.add(temp.data);
	            if(temp.left!=null)
	                s2.push(temp.left);
                if(temp.right!=null)
	                s2.push(temp.right);
	        }
	        while(!s2.isEmpty()){
	            Node temp = s2.pop();
                res.add(temp.data);
                if(temp.right!=null)
                    s1.push(temp.right);
                if(temp.left!=null)
                    s1.push(temp.left);
	        }
	    }
	    return res;
	}
}
```