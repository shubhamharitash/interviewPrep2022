## Problem Statement
https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/
#ImportantQuestionBST

## Approaches
#### Approach 1(Bottom Up Approach)(O(n))
Here we take advantage of bottom up approach to reduce complexity from O(nlogn) tom O(n) by using inorder traversal.

###### Code
```java
class Solution {
    public static ListNode ptr=null;
    public static int lengthOfList(ListNode head){
        int cnt = 0;
        while(head!=null){
            head = head.next;
            cnt++;
        }
        return cnt;
    }
    public static TreeNode solve(int n){
        if(n==0)
            return null;
        TreeNode left = solve(n/2);
        TreeNode root = new TreeNode(ptr.val);
        ptr = ptr.next;
        root.left = left;
        root.right = solve(n-n/2-1);
        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {
        int n = lengthOfList(head);
        ptr = head;
        return solve(n);
    }
}
```