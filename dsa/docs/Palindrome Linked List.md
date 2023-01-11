![[Palindrome Linked List-1673374098444.jpeg]]
**Approach 1**
obtain string from list
check if string is palindrome

**Approach 2**
obtain length of list
place pointer at middle and iterate both list

**Approach 3**
1) use fast pointer method to make one pointer reach middle
2) then reverse the list at slow pointer
3) compare two lists

```java
class Solution {

public static ListNode reverseLL(ListNode head){

ListNode prev = null;

while(head!=null){

ListNode temp = head.next;

head.next = prev;

prev = head;

head = temp;

}

return prev;

}

public boolean isPalindrome(ListNode head) {

ListNode slowPtr = head;

ListNode fastPtr = head;

while(fastPtr != null && fastPtr.next != null){

// System.out.println(slowPtr.val + "," + fastPtr.val);

slowPtr = slowPtr.next;

fastPtr = fastPtr.next.next;

}

ListNode midPtr;

if(fastPtr!=null){

midPtr = slowPtr;

slowPtr = slowPtr.next;

}

slowPtr = reverseLL(slowPtr);

while(slowPtr!=null){

// System.out.println(slowPtr.val + "," + head.val);

if(slowPtr.val != head.val)

return false;

slowPtr = slowPtr.next;

head = head.next;

}

  

return true;

}

}
```
