## Introduction

#### Abstract Data Type
- Data type with
    - data
    - operations
- Commonly used
    - Linked Lists
    - Stacks
    - Queues
    - Priority Queues
    - Binary Trees
    - Dictionaries
    - Disjoint Sets
    - Hash Tables
    - Graphs
- eg for linkedList
    - LinkedListNode
        - Node1 --> Node 2 --> Node 3
        - Node1
            - head
            - rear
            - data
    - LinkedList
        - head
        - addNewNode
        - removeNode
        - removeNodeFromGivenIndex
- 

#### Types of Analysis
- Worst Case
    - Big O Notation
- Best Case
    - Omega Notation
- Average Case
    - Theta Notation

#### Time analysis example
- Simple Example
```java
int i;// O(1)
for(int i=0;i<n;i++){
    System.out.println("Hello World");//O(1)
}// c*n = O(n)
// c + c*n = O(n)
```

- Lograthimic Example
    - Example 1
    ```python
    def Logarithms(n):
        i = 1
        while i <= n:
            i= i * 2
            print(i)
    Logarithms(IOO)
    ```
    i = 2^x >=n
    No, of times Line 54 executed == x+1
    Total time complexity = x+1
    log2(2^x) >=log2(n)
    xlog2(2)>=log2(n)
    x>=log2(n)
    Therefore
        Time complexity = log2(n)+1 = O(log2(n))

    - Example 2
    ```python
    def Logarithms(n):
        i = n
        while i >= 1:
            i= i // 2
            print(i)
    Logarithms(IOO)
    ```
    n/(2^x) <=1
    n <= 2^x
    2^x >= n
    Proceed as above example

#### Master Theorem
T(n) = aT(n/b) + O(n^klog^p(n))
where a>=1, b>1, k>=0 and p is real then

- if a > b^k
    - T(n) = O(n^(log_b(a)))
- if a == b^k
    - p > -1
        - T(n) = O(n^(log_b(a))log^(p+1)(n))
    - p = -1
        - T(n) = O(n^(log_b(a))loglogn)
    - p < -1
        - T(n) = O(n^(log_b(a)))
- if a < b^k
    - if p >= 0
        - T(n) = O(n^klog^p(n))
    - If p < 0
        - T(n) = O(n^k)

- Derivation
```
T(n) = 3T(n/2) + n^2
a = 3, b = 2, p = 0, k = 2

T(n) = 3(3T(n/4)+(n/2)^2) + n^2
     = 3^2T(n/2^2) + n^2(1 + 1/2^2)
Let 2^x == n in this recurrence relation then
    = 3^xT(n/2^x) + n^2(1/(2^0)^2 + 1/(2^1)^2 + ... + 1/(2^x)^2)
    = 3^x + n^2(1-(1/2^2)^x)/(1-1/4)
    = 3^x + n^2(1-(1/2n))*(4/3)
    = 3^log_2(n) + (n^2 -2n)*4/3
Overall T(n) == O(n^2)
```
- Questions
