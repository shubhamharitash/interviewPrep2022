## Problem Statement
https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/description/

## Approaches
#### Approach 1
![[Maximum Twin Sum of a Linked List-1675904148136.jpeg]]

###### Code
```java
public static ListNode middleOfLL(ListNode head){

ListNode slowPtr = head;

ListNode fastPtr = head;

while(fastPtr != null && fastPtr.next.next!= null){

slowPtr = slowPtr.next;

fastPtr = fastPtr.next.next;

}

return slowPtr;

}

public static ListNode reverseLL(ListNode head){

ListNode prev = null;

ListNode cur = head;

while(cur!=null){

ListNode temp = cur.next;

cur.next = prev;

prev = cur;

cur = temp;

}

return prev;

}

public static void printLL(ListNode head){

while(head!=null){

head = head.next;

}

System.out.println();

}

public int pairSum(ListNode head) {

ListNode middleNode = middleOfLL(head);

ListNode reversedLL = reverseLL(middleNode.next);

middleNode.next = null;

int res = 0;

while(head!=null){

int twinSum = head.val + reversedLL.val;

res = twinSum > res ? twinSum : res;

head = head.next;

reversedLL = reversedLL.next;

}

return res;

}
```