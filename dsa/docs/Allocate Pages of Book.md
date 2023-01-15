## Problem Statement
There exists array of books with number of pages in it. these books need to be divided among students such that
1) Each student has a book
2) Each student will read individial book
3) each student can only be allotted books in continuous fashion
with these restrictions, minimize maximum number of pages read by the student
>Note: Array is unsorted

## Approaches
#### Approach 1
minimize maximum number of pages read by the student
For 10 20 30 40, k=2
ans is 60

Range in which ans lies
0.....................60............................100
Improved number line according to constraints
40(Max in arr)................60.................100(Total of arr)

thus we set number of pages which each student can read then apply check to find whether it can be done or not.

###### Code
```java
```

