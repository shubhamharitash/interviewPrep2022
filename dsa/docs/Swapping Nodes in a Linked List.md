## Problem Statement
https://leetcode.com/problems/swapping-nodes-in-a-linked-list/description/

## Approaches
#### Approach 1
1) We swap only next pointers
2) If previous pointerX not null then 
	1) `prevX.next = currY`
3) else
	1) `head = currY`

###### Code
```java
public void swapNodes(int x, int y)
{
	// Nothing to do if x and y are same
	if (x == y)
		return;

	// Search for x (keep track of prevX and CurrX)
	Node prevX = null, currX = head;
	while (currX != null && currX.data != x) {
		prevX = currX;
		currX = currX.next;
	}

	// Search for y (keep track of prevY and currY)
	Node prevY = null, currY = head;
	while (currY != null && currY.data != y) {
		prevY = currY;
		currY = currY.next;
	}

	// If either x or y is not present, nothing to do
	if (currX == null || currY == null)
		return;

	// If x is not head of linked list
	if (prevX != null)
		prevX.next = currY;
	else // make y the new head
		head = currY;

	// If y is not head of linked list
	if (prevY != null)
		prevY.next = currX;
	else // make x the new head
		head = currX;

	// Swap next pointers
	Node temp = currX.next;
	currX.next = currY.next;
	currY.next = temp;
}
```

#### Approach 2
![[Swapping Nodes in a Linked List-1675964178695.jpeg]]

###### Code
```java
public ListNode swapNodes(ListNode head, int k) {
        int n = computeLengthOfLL(head);
        int startPos = k-1 < (n-k) ? k-1 : (n-k);
        int endPos = k-1 > (n-k) ? k-1 : (n-k);
        ListNode startNode = head;
        ListNode prevStartNode = null;
        ListNode nextStartNode = startNode.next;

        ListNode endNode = head;
        ListNode prevEndNode = null;
        ListNode nextEndNode = endNode.next;
        for(int i=0;i<startPos;i++){
            prevStartNode = startNode;
            startNode = startNode.next;
            if(startNode!=null)
                nextStartNode = startNode.next;
        }
        for(int i=0;i<endPos;i++){
            prevEndNode = endNode;
            endNode = endNode.next;
            if(endNode!=null)
                nextEndNode = endNode.next;
        }
        // System.out.println(startNode.val);
        // System.out.println(endNode.val);
        // // System.out.println(nextStartNode.val);
        if(prevEndNode == startNode){
            endNode.next = startNode;
            startNode.next = nextEndNode;
            if(prevStartNode != null){
                prevStartNode.next = endNode;
            }
        } else {
            startNode.next = endNode.next;
            endNode.next = nextStartNode;
            if(prevStartNode != null)
                prevStartNode.next = endNode;
            if(prevEndNode != null)
                prevEndNode.next = startNode;
        }
        if(startPos==0)
            return endNode;
        return head;
    }
```