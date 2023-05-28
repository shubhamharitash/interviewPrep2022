## Problem Statement
https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/

## Approaches
#### Approach 1
we recur untill root is null. there we add the element.

###### Code
```java
class Solution {
    // Function to insert a node in a BST.
    Node insert(Node root, int key) {
        // your code here
        if(root==null)
            return new Node(key);
        if(root.data==key)
            return root;
        if(key<root.data)
            root.left = insert(root.left, key);
        else
            root.right = insert(root.right, key);
        return root;
    }
}
```