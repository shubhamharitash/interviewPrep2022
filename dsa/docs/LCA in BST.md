## Problem Statement

## Approaches
#### Approach 1
LCA in BST is less complex because we are able to determine on the basis of data.
[[Least Common Ancestor]] is more time complex

###### Code
```java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return null;
        if(root==p||root==q)
            return root;
        if(root.val>Math.max(p.val, q.val))
            return lowestCommonAncestor(root.left, p, q);
        if(root.val<Math.min(p.val, q.val))
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}
```