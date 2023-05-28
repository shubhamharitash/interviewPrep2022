## Problem Statement
https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/

## Approaches
#### Approach 1(Range Approach)
![[Check if BST or not-1678393519925.jpeg]]

###### Code
```java
class Data{
    int start;
    int end;
    boolean isBst;
    Data(int start, int end, boolean isBst){
        this.start = start;
        this.end = end;
        this.isBst = isBst;
    }
}
public class Solution
{
    //Function to check whether a Binary Tree is BST or not.
    public static Data checkIfBst(Node root){
        if(root==null){
            return new Data(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }
        Data left = checkIfBst(root.left);
        Data right = checkIfBst(root.right);
        boolean leftCompare = root.data>left.end;
        boolean rightCompare = root.data<right.start;
        if(!left.isBst || !right.isBst || !leftCompare || !rightCompare)
            return new Data(0, 0, false);
        return new Data(Math.min(left.start, root.data), Math.max(right.end, root.data), true);
    }
    boolean isBST(Node root)
    {
        return checkIfBst(root).isBst;
    }
}
```

#### Approach 2(Inorder traversal)
Using a static variable which keeps track of element traversed, using inorder traversal we can calculate if given tree is bst or not 😄

###### Code
```java
public class Solution
{
    //Function to check whether a Binary Tree is BST or not.
    public static int prev = Integer.MIN_VALUE;
    public static boolean helper(Node root){
        if(root==null)
            return true;
        if(!helper(root.left))
            return false;
        if(root.data <= prev)
            return false;
        prev = root.data;
        return helper(root.right);
    }
    boolean isBST(Node root)
    {
        prev = Integer.MIN_VALUE;
        return helper(root);
    }
}
```