## Problem Statement
https://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/

## Approaches
#### Approach 1
preorder will give us which node to process
inorder will give us the structure
![[Construct Tree from Inorder & Preorder-1678257588535.jpeg]]
Choosing correct indexes here is important

###### Code
```java
class Solution
{
    public static Node helper(int inorder[], int preorder[], int inStart, int inEnd, int preStart, int preEnd){
        if(inStart>inEnd || preStart>preEnd)
            return null;
        int ele = preorder[preStart];
        int pivot = -1;
        for(int i=inStart; i<=inEnd; i++){
            if(inorder[i]==ele){
                pivot=i;
                break;
            }
        }
        Node root = new Node(ele);
        root.left = helper(inorder, preorder, inStart, pivot-1, preStart+1, preStart+(pivot-inStart));
        root.right = helper(inorder, preorder, pivot+1, inEnd, preStart+(pivot-inStart)+1, preEnd);
        return root;
    }
    public static Node buildTree(int inorder[], int preorder[], int n)
    {
        return helper(inorder, preorder, 0, n-1, 0, n-1);
    }
}

```