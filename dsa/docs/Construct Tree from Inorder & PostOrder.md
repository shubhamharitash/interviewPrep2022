## Problem Statement
https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/

## Approaches
#### Approach 1
![[Construct Tree from Inorder & PostOrder-1678259252242.jpeg]]

###### Code
```java
class Solution {
    public static TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd){
        if(inStart>inEnd || postStart>postEnd)
            return null;
        int ele = postorder[postEnd];
        int pivot = -1;
        for(int i=inStart; i<=inEnd; i++){
            if(inorder[i]==ele){
                pivot = i;
                break;
            }
        }
        TreeNode left = helper(inorder, postorder, inStart, pivot-1, postStart, postStart + (pivot-inStart)-1);
        TreeNode right =helper(inorder, postorder, pivot+1, inEnd, postStart + (pivot-inStart), postEnd-1);
        return new TreeNode(ele, left, right);
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return helper(inorder, postorder, 0, n-1, 0, n-1);
    }
}
```