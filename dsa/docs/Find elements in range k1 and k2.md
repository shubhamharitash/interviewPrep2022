## Problem Statement
https://www.geeksforgeeks.org/print-bst-keys-in-the-given-range/

## Approaches
#### Approach 1(Recursion)
Simple recursion

###### Code
```java
class Solution
{   
    //Function to return a list of BST elements in a given range.
	public static ArrayList<Integer> printNearNodes(Node root,int low,int high) {
        if(root==null)
            return new ArrayList<>();
        if(root.data<low)
            return printNearNodes(root.right, low, high);
        if(root.data>high)
            return printNearNodes(root.left, low, high);
        ArrayList<Integer> res = new ArrayList<>();
        res.addAll(printNearNodes(root.left, low, high));
        res.add(root.data);
        res.addAll(printNearNodes(root.right, low, high));
        return res;
    }
    
}
```

#### Approach 2(Level order)
We can use level order traversal also
but it would destroy the order required.