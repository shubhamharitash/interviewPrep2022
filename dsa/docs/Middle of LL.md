```java
public ListNode middleNode(ListNode head) {  
    ListNode slowPtr = head;  
    ListNode fastPtr = head;  
    while (fastPtr != null && fastPtr.next != null) {  
        slowPtr = slowPtr.next;  
        fastPtr = fastPtr.next.next;  
    }  
    ListNode midPtr = slowPtr;  
    if (fastPtr != null) {  
        slowPtr = slowPtr.next;  
    }  
    return midPtr;  
}
```