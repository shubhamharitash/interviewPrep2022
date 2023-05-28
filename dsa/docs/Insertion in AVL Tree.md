## Problem Statement
https://www.geeksforgeeks.org/insertion-in-an-avl-tree/

## Approaches
#### Approach 1
Insertion is similar to [[Insert a node in BST]]
Difference being that whenever we insert a node to left or right, we check the balancing factor and perform balancing if required.
Also height is updated for root so that any height changes in left or right are captured.

###### Code
```java
class Solution
{
    public static boolean balanceFactorComp(Node node1, Node node2){
        if(node1 == null)
            return false;
        if(node2 == null)
            return node1.height==2;
        return (node1.height - node2.height) == 2;
    }
    public static int heightMax(Node node1, Node node2){
        int res = 0;
        if(node1!=null)
            res = node1.height;
        return node2!=null? Math.max(res, node2.height):res;
    }
    public static Node singleRotateLL(Node root){
        Node p = root;
        Node q = root.left;
        p.left = q.right;
        q.right = p;
        p.height = heightMax(p.left, p.right) + 1;
        q.height = heightMax(q.left, q.right) + 1;
        return q;
    }
    public static Node singleRotateRR(Node root){
        Node p = root;
        Node q = root.right;
        p.right = q.left;
        q.left = p;
        p.height = heightMax(p.left, p.right) + 1;
        q.height = heightMax(q.left, q.right) + 1;
        return q;
    }
    public static Node doubleRotateLR(Node root){
        root.left = singleRotateRR(root.left);
        return singleRotateLL(root);
    }
    public static Node doubleRotateRL(Node root){
        root.right = singleRotateLL(root.right);
        return singleRotateRR(root);
    }
    public  Node insertToAVL(Node root, int data)
    {
        if(root==null)
            return new Node(data);
        if(data<root.data){
            root.left = insertToAVL(root.left, data);
            if(balanceFactorComp(root.left, root.right)){
                if(data < root.left.data){
                    root = singleRotateLL(root);
                } else {
                    root = doubleRotateLR(root);
                }
            }
        } else if(data>root.data){
            root.right = insertToAVL(root.right, data);
            if(balanceFactorComp(root.right, root.left)){
                if(data > root.right.data){
                    root = singleRotateRR(root);
                } else {
                    root = doubleRotateRL(root);
                }
            }
        }
        root.height = heightMax(root.left, root.right) + 1;
        return root;
    }
}    
```