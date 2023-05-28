## Problem Statement
https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/

## Approaches
#### Approach 1
Similar bottom up approach as [[Sorted List To BST]]

###### Code
```java
class Solution {
    public static int cnt = 0;
    public static TreeNode helper(TreeNode root, int k){
        if(root==null)
            return null;
        TreeNode left = helper(root.left, k);
        if(left!=null)
            return left;
        if(++cnt==k)
            return root;
        return helper(root.right, k);
    }
    public int kthSmallest(TreeNode root, int k) {
        cnt = 0;
        return helper(root, k).val;
    }
}
```