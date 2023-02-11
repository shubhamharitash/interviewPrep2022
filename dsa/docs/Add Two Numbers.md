## Problem Statement
https://leetcode.com/problems/add-two-numbers/description/

## Approaches
#### Approach 1
Simple math with recursion

###### Code
```java
public static ListNode solve(ListNode l1, ListNode l2, int carry){

if(l1 == null && l2 == null)

return carry!=0 ? new ListNode(carry): null;

ListNode node;

if(l1 == null){

node = new ListNode((l2.val + carry)%10);

carry = (l2.val + carry)/10;

node.next = solve(l1, l2.next, carry);

System.out.println("Case1"+node.val);

return node;

}

if(l2 == null){

node = new ListNode((l1.val + carry)%10);

carry = (l1.val + carry)/10;

node.next = solve(l1.next, l2, carry);

return node;

}

node = new ListNode((l1.val + l2.val + carry)%10);

carry = (l1.val + l2.val + carry)/10;

ListNode subProblem = solve(l1.next, l2.next, carry);

node.next = subProblem;

System.out.println("Case3"+node.val);

return node;

}

public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

return solve(l1,l2,0);

}
```

