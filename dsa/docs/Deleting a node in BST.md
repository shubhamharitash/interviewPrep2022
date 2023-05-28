## Problem Statement

## Approaches
#### Approach 1
![[Deleting a node in BST-1678376665606.jpeg]]

###### Code
```java
class Solution {
    public static TreeNode rightMostNode(TreeNode root){
        while(root.right!=null)
            root = root.right;
        return root;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
            return null;
        if(key<root.val){
            root.left = deleteNode(root.left, key);
            return root;
        }
        if(key>root.val){
            root.right = deleteNode(root.right, key);
            return root;
        }
        if(root.left==null && root.right==null)
            return null;
        if(root.left!=null && root.right!=null){
            TreeNode temp = rightMostNode(root.left);
            root.val = temp.val;
            root.left = deleteNode(root.left, temp.val);
            return root;
        }
        return root.left!=null? root.left:root.right;
    }
}
```