## Problem Statement
https://www.geeksforgeeks.org/write-c-code-to-determine-if-two-trees-are-identical/

## Approaches
#### Approach 1
Perform level order traversal simultaneously and check both data and structure.

###### Code
```java
class Solution
{
    //Function to check if two trees are identical.
	boolean isIdentical(Node root1, Node root2)
	{
	    // Code Here
	    Queue<Node> q1 = new LinkedList<>();
	    Queue<Node> q2 = new LinkedList<>();
	    q1.offer(root1);
	    q2.offer(root2);
	    while(!q1.isEmpty()){
            Node temp1 = q1.poll();
            Node temp2 = q2.poll();
            if(temp1.data != temp2.data)
                return false;
            boolean isLeftChildNotSimilar = (temp1.left!=null && temp2.left==null) || (temp1.left==null && temp2.left!=null);
            boolean isRightChildNotSimilar = (temp1.right!=null && temp2.right==null) || (temp1.right==null && temp2.right!=null);
            
            if(isLeftChildNotSimilar || isRightChildNotSimilar)
                return false;
            if(temp1.left!=null){
                q1.offer(temp1.left);
                q2.offer(temp2.left);
            }
            if(temp1.right!=null){
                q1.offer(temp1.right);
                q2.offer(temp2.right);
            }
	    }
	    return true;
	}
	
}
```

#### Approach 2(Using recursion)
We just apply checks for root rest is handled by recursive logic.

###### Code
```java
boolean isIdentical(Node root1, Node root2)
{
	// Code Here
	if(root1==null && root2 == null)
		return true;
	if(root1==null || root2==null || root1.data!=root2.data)
		return false;
	return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
}
```