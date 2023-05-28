## Problem Statement
https://www.geeksforgeeks.org/print-ancestors-of-a-given-node-in-binary-tree/

## Approaches
#### Approach 1
If path has an element, we add to that path else we ignore the path.

###### Code
```java
class Solution
{
    public static ArrayList<Integer> helper(Node root, int target){
        if(root==null)
            return new ArrayList<Integer>();
        if(root.data==target){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(target);
            return temp;
        }
        ArrayList<Integer> leftPath = helper(root.left, target);
        ArrayList<Integer> rightPath = helper(root.right, target);
        if(leftPath.size()!=0){
            leftPath.add(root.data);
            return leftPath;
        }
        if(rightPath.size()!=0){
            rightPath.add(root.data);
            return rightPath;
        }
        return new ArrayList<Integer>(); 
    }
    public static ArrayList<Integer> Ancestors(Node root, int target)
    {
        // add your code here
        ArrayList<Integer> temp = helper(root, target);
        ArrayList<Integer> res = new ArrayList<>();
        if(temp.size()>1){
            res.addAll(temp.subList(1, temp.size()));
        }
        return res;
    }
}
```