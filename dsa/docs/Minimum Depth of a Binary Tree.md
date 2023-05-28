## Problem Statement
https://leetcode.com/problems/minimum-depth-of-binary-tree/description/

## Approaches
#### Approach 1
Simple recursion

###### Code
```java
class Solution {
    public static int helper(TreeNode root){
        if(root==null)
            return Integer.MAX_VALUE;
        if(root.left == null && root.right == null)
            return 1;
        return 1 + Math.min(helper(root.left), helper(root.right)); 
    }
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        return helper(root);
    }
}
```