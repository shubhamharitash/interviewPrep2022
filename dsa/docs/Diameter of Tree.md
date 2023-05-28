## Problem Statement
https://leetcode.com/problems/diameter-of-binary-tree/description/

## Approaches
#### Approach 1(Using global variable)
![[Diameter of Tree-1678120753662.jpeg]]

###### Code
```java
class Solution {
    public static int res = 0;
    public static int helper(TreeNode root){
        if(root==null)
            return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        res = Math.max(res, left + right);
        return Math.max(left, right) + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        res = 0;
        helper(root);
        return res;
    }
}
```

#### Approach 2(Using height)
![[Diameter of Tree-1678120802477.jpeg]]
