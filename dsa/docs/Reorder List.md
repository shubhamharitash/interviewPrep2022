## Problem Statement
https://leetcode.com/problems/reorder-list/description/

## Approaches
#### Approach 1
1) Find Middle
2) reverse LL from middleNode.next
3) break link(middleNode.next = null)
4) merge using two pointers(Imp logic for LL)

###### Code
```java
public static ListNode middleOfList(ListNode head) {  
    ListNode slowPtr = head;  
    ListNode fastPtr = head;  
    while (fastPtr != null && fastPtr.next != null) {  
        slowPtr = slowPtr.next;  
        fastPtr = fastPtr.next.next;  
    }  
    return slowPtr;  
}  
  
public static ListNode reverseLL(ListNode head) {  
    ListNode prev = null;  
    ListNode cur = head;  
    ListNode next = null;  
    while (cur != null) {  
        next = cur.next;  
        cur.next = prev;  
        prev = cur;  
        cur = next;  
    }  
    return prev;  
}  
  
public void reorderList(ListNode head) {  
    ListNode middleNode = middleOfList(head);  
    ListNode head1 = head;  
    ListNode head2 = reverseLL(middleNode.next);  
    middleNode.next = null;  
    while(head2 != null){  
        ListNode next = head1.next;  
        head1.next = head2;  
        head1 = head2;  
        head2 = next;  
    }  
}
```

