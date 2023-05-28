## Problem Statement
https://www.geeksforgeeks.org/deletion-binary-tree/

## Approaches
#### Approach 1
![[Deleting an Element in BT-1678117691116.jpeg]]

###### Code
```java
class Solution {
    public static Node findDeepestNode(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node res = null;
        while(!queue.isEmpty()){
            res = queue.poll();
            if(res.left!=null)
                queue.add(res.left);
            if(res.right!=null)
                queue.add(res.right);
        }
        return res;
    }
    public static Node findKey(Node root, int key){
        if(root==null){
            return null;
        }
        if(root.data == key)
            return root;
        Node ans1 = findKey(root.left, key);
        if(ans1!=null)
            return ans1;
        Node ans2 = findKey(root.right, key);
        return ans2;
    }
    public static Node helper(Node root, Node deepestNode){
        if(root==null || root==deepestNode){
            return null;
        }
        root.left = helper(root.left, deepestNode);
        root.right = helper(root.right, deepestNode);
        return root;
    }
    public Node deletionBT(Node root, int key){
        //Write your code here and return the root of the changed tree
        Node deepestNode = findDeepestNode(root);
        Node keyNode = findKey(root, key);
        keyNode.data = deepestNode.data;
        return helper(root, deepestNode);
    }
}
```