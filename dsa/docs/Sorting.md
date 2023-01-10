## Some important terms

#### In-place sorting
Sorting which modifies given input array without using extra space. Space complexity should be $O(1)$.

#### External Sorting
Used on chunks of data to sort massive amount of numbers.

#### Stability in sorting algorithms 
if two objects with same keys are in input, they appear in same order as in input i the output.

## Sorting Algorithms
1) [[Bubble Sort]]
2) [[Selection Sort]]
3) [[Insertion Sort]]
4) [[Quick Sort]]
5) [[Merge sort]]

#### [[SortingQuestions]]

#### Easiest Way to Sort a collection
```java
System.out.println(tracks.stream().sorted(Comparator.comparing(Track::getLength)).collect(Collectors.toList()));
```
