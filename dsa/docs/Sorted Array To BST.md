## Problem Statement

## Approaches
#### Approach 1
Simple recursive approach

###### Code
```java
class Node{
    Node left;
    Node right;
    int data;
    Node(){
        left=right=null;
    }
    Node(int data){
        left=right=null;
        this.data = data;
    }
    Node(Node left, Node right, int data){
        this.left = left;
        this.right = right;
        this.data = data;
    }
}
class Solution
{
    public static Node helper1(int[] nums, int start, int end){
        if(start>end)
            return null;
        int mid = start+(end-start)/2;
        Node root = new Node(nums[mid]);
        root.left = helper1(nums, start, mid-1);
        root.right = helper1(nums, mid+1, end);
        return root;
    }
    public static ArrayList<Integer> helper2(Node root){
        if(root==null)
            return new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        res.add(root.data);
        res.addAll(helper2(root.left));
        res.addAll(helper2(root.right));
        return res;
    }
    public int[] sortedArrayToBST(int[] nums)
    {
        Node root = helper1(nums, 0, nums.length-1);
        ArrayList<Integer> res = helper2(root);
        return res.stream().mapToInt((Integer i) -> i).toArray();
    }
}
```