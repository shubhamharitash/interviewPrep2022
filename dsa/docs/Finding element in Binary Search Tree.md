## Problem Statement
https://leetcode.com/problems/search-in-a-binary-search-tree/description/

## Approaches
#### Approach 1
Recur left or right

###### Code
```java
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null || root.val==val)
            return root;
        TreeNode left = searchBST(root.left, val);
        if(left!=null)
            return left;
        return searchBST(root.right, val);
    }
}
```