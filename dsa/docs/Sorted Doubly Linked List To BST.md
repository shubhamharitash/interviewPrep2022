## Problem Statement

## Approaches
#### Approach 1
![[Sorted Doubly Linked List To BST-1678533256848.jpeg]]
![[Sorted Doubly Linked List To BST-1678533273147.jpeg]]
Complexity nlogn since time also taken for searching middle.

#### Approach 2(Bottom Up)
![[Sorted Doubly Linked List To BST-1678533868849.jpeg]]
Here we find the length to the list and use that to perform recursive calls while updating head. This saves us the time to find middle, essentially reducing time complexity to O(n).