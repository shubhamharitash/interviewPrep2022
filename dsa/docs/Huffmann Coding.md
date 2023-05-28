## Problem Statement
https://www.geeksforgeeks.org/huffman-coding-greedy-algo-3/

## Approaches
#### Approach 1
![[Huffmann Coding-1679697107561.jpeg]]
![[Huffmann Coding-1679697123088.jpeg]]

> Note: In priorityQueue whenever we are given that if key same then element which is inserted first to be picked, in comparator we supply value 1
> `PriorityQueue<TreeNode> pq = new PriorityQueue<>((a, b) -> a.value!=b.value?a.value-b.value:1);`

###### Code
```java
class TreeNode{
    int value;
    char letter;
    TreeNode left;
    TreeNode right;
    TreeNode(int value, TreeNode left, TreeNode right){
        letter = '\0';
        this.value = value;
        this.left = left;
        this.right = right;
    }
    TreeNode(char letter, int value){
        this.value = value;
        this.letter = letter;
    }
}
class Solution {
    public void helper(TreeNode root, String s, ArrayList<String> res){
        if(root==null)
            return;
        if(root.letter!='\0'){
            res.add(s);
        }
        helper(root.left, s + "0", res);
        helper(root.right, s + "1", res);
    }
    public ArrayList<String> huffmanCodes(String s, int f[], int N)
    {
        // imp logic 
        // Here 1 denotes that pick value which is coming first which is a
        PriorityQueue<TreeNode> pq = new PriorityQueue<>((a, b) -> a.value!=b.value?a.value-b.value:1);
        for(int i=0; i<f.length; i++){
            pq.add(new TreeNode(s.charAt(i), f[i]));
        }
        int cnt = f.length;
        while(pq.size()>1){
            TreeNode temp1 = pq.remove();
            TreeNode temp2 = pq.remove();
            TreeNode newNode = new TreeNode(temp1.value + temp2.value, temp1, temp2);
            pq.add(newNode);
        }
        TreeNode root = pq.remove();
        ArrayList<String> res = new ArrayList<>();
        helper(root, "", res);
        return res;
    }
}
```