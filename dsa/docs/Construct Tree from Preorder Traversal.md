## Problem Statement
https://www.geeksforgeeks.org/construct-a-special-tree-from-given-preorder-traversal/

## Approaches
#### Approach 1
Here, we take help of class' property that it gets updated inside function since its passed as reference. 
This helps us first construct left tree then right tree using preorder traversal since we know each node has either 2 or 0 children.

###### Code
```java
class Index{
    int index=0;
}
class Solution{
    public static Node helper(int pre[], char preLN[], Index i){
        if(pre.length==i.index)
            return null;
        Node temp = new Node(pre[i.index]);
        if(preLN[i.index]=='L')
            return temp;
        i.index++;
        temp.left = helper(pre, preLN, i);
        i.index++;
        temp.right = helper(pre, preLN, i);
        return temp;
    }
    Node constructTree(int n, int pre[], char preLN[]){
	    return helper(pre, preLN, new Index());
    }
}
```