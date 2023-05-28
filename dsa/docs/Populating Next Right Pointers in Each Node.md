## Problem Statement
https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/

## Approaches
#### Approach 1(Space Efficient)
Here we take advantage of next pointers to prevent using queue which saves us space complexity
![[Populating Next Right Pointers in Each Node-1678634048719.jpeg]]

###### Code
```java
class Solution {
    public Node connect(Node root) {
        if(root==null)
            return root;
        Node ptr = root;
        Node lvlStart = root;
        Node prev = null;
        while(ptr!=null){
            if(ptr.left!=null){
                ptr.left.next = ptr.right;
                if(prev!=null)
                    prev.next = ptr.left;
                prev = ptr.right;
            }
            if(ptr.next!=null){
                ptr = ptr.next;
            } else {
                ptr = lvlStart.left;
                lvlStart = lvlStart.left;
                prev = null;
            }
        }
        return root;
    }
}
```