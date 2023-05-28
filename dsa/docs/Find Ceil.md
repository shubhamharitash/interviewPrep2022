## Problem Statement
https://practice.geeksforgeeks.org/problems/implementing-ceil-in-bst/1

## Approaches
#### Approach 1
Similiar approach as [[Sorted List To BST]]

###### Code
```java
class Tree {
    // Function to return the ceil of given number in BST.
    int findCeil(Node root, int key) {
        if (root == null) 
            return -1;
        int left = findCeil(root.left, key);
        if(left!=-1)
            return left;
        if(root.data>=key)
            return root.data;
        return findCeil(root.right, key);
    }
}
```