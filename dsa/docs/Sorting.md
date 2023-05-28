## Some important terms

#### In-place sorting
Sorting which modifies given input array without using extra space. Space complexity should be $O(1)$.

#### External Sorting
Used on chunks of data to sort massive amount of numbers.

#### Stability in sorting algorithms 
if two objects with same keys are in input, they appear in same order as in input i the output.

## Sorting Algorithms
Basic Algos
1) [[Bubble Sort]]
2) [[Selection Sort]]
3) [[Insertion Sort]]
All of them inplace and stable, but can't external sort

Best Time Complexity Algorithms
1) [[Quick Sort]]
2) [[Merge sort]]

#### [[SortingQuestions]]
#### [[Leetcode Problems Sorting]]

#### Easiest Way to Sort a collection
```java
System.out.println(tracks.stream().sorted(Comparator.comparing(Track::getLength)).collect(Collectors.toList()));
```
