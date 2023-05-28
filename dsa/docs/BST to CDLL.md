## Problem Statement
https://www.geeksforgeeks.org/convert-a-binary-tree-to-a-circular-doubly-link-list/

## Approaches
#### Approach 1
Simply focus on problem and adjust links correctly.
![[BST to CDLL-1678531940946.jpeg]]

###### Code
```java
class Data{
    Node head;
    Node tail;
    Data(){
        head=tail=null;
    }
    Data(Node head, Node tail){
        this.head=head;
        this.tail=tail;
    }
}
class Solution
{ 
    //Function to convert binary tree into circular doubly linked list.
    public static int cnt = 0;
    public static Data helper(Node root){
        if(root==null)
            return new Data();
        Data left = helper(root.left);
        Data right = helper(root.right);
        Node head=root;
        Node tail=root;
        if(left.tail!=null){
            head = left.head;
            left.tail.right = root;
            root.left = left.tail;
        } 
        if(right.head!=null){
            tail = right.tail;
            right.head.left = root;
            root.right = right.head;
        } 
        tail.right=head;
        head.left=tail;
        return new Data(head, tail);
    }
    Node bTreeToClist(Node root)
    {
        return helper(root).head;
    }
    
}
```