## Problem Statement
https://leetcode.com/problems/trim-a-binary-search-tree/description/

## Approaches
#### Approach 1
We only keep the require node while doing the recursion

###### Code
```java
class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root==null)
            return null;
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        if(root.val<low)
            return root.right;
        if(root.val>high)
            return root.left;
        return root;
    }
}
```