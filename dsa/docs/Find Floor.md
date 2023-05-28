## Problem Statement
https://practice.geeksforgeeks.org/problems/floor-in-bst/1?category%5B%5D=Binary%20Search%20Tree&page=1&sortBy=accuracy&query=category%5B%5DBinary%20Search%20Treepage1sortByaccuracy

## Approaches
#### Approach 1
Similar to [[Find Ceil]], only direction of traversal changes.

###### Code
```java
class Solution {
    public static int floor(Node root, int key) {
        // Code here
        if (root == null) 
            return -1;
        int right = floor(root.right, key);
        if(right!=-1)
            return right;
        if(root.data<=key)
            return root.data;
        return floor(root.left, key);
    }
}
```