## Problem Statement
https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/description/

## Approaches
#### Approach 1
![[Convert Binary Number in a Linked List to Integer-1675699888424.jpeg]]

###### Code
```java
class Solution {

public int getDecimalValue(ListNode head) {

int res = 0;

for(ListNode item = head; item != null; item = item.next){

res = (res<<1) + item.val;

}

return res;

}

}
```