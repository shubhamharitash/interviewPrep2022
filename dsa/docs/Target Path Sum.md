## Problem Statement
https://leetcode.com/problems/path-sum/description/

## Approaches
#### Approach 1
Simple recursive approach

###### Code
```java
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)
            return false;
        if(root.left==null && root.right==null)
            return root.val==targetSum;
        return hasPathSum(root.left, targetSum-root.val) || hasPathSum(root.right, targetSum-root.val);
    }
}
```