## Problem Statement
https://www.geeksforgeeks.org/deletion-in-an-avl-tree/

## Approaches
#### Approach 1
Similar to [[Deleting a node in BST]]
Here for deciding which rotation needs to be performed we take help of height of tree
![[Deletion in AVL Tree-1678618058904.jpeg]]

###### Code
```java
class Sol
{
    public static Node rightMostNode(Node root){
        while(root.right!=null)
            root = root.right;
        return root;
    }
    public static boolean balanceFactorComp(Node node1, Node node2, int val{
        if(node1 == null)
            return false;
        if(node2 == null)
            return node1.height==val;
        return (node1.height - node2.height) == val;
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
    public static Node deleteNode(Node root, int key)
    {
        if(root==null)
            return null;
        if(key<root.data){
            root.left = deleteNode(root.left, key);
            if(balanceFactorComp(root.right, root.left, 2)){
                if(balanceFactorComp(root.right.left, root.right.right, 1)){
                    root = doubleRotateRL(root);
                } else {
                    root = singleRotateRR(root);
                }
            }
            root.height = heightMax(root.left, root.right) + 1;
            return root;
        }
        if(key>root.data){
            root.right = deleteNode(root.right, key);
            if(balanceFactorComp(root.left, root.right, 2)){
                if(balanceFactorComp(root.left.right, root.left.left, 1)){
                    root = doubleRotateLR(root);
                } else {
                    root = singleRotateLL(root);
                }
            }
            root.height = heightMax(root.left, root.right) + 1;
            return root;
        }
        if(root.left==null && root.right==null)
            return null;
        if(root.left!=null && root.right!=null){
            Node temp = rightMostNode(root.left);
            root.data = temp.data;
            root.left = deleteNode(root.left, temp.data);
            if(balanceFactorComp(root.right, root.left, 2)){
                if(balanceFactorComp(root.right.left, root.right.right, 1)){
                    root = doubleRotateRL(root);
                } else {
                    root = singleRotateRR(root);
                }
            }
            root.height = heightMax(root.left, root.right) + 1;
            return root;
        }
        return root.left!=null? root.left:root.right;
    }
}
```