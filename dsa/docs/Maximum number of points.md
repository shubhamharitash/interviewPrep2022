## Problem Statement
https://leetcode.com/problems/maximum-points-in-an-archery-competition/description/

## Approaches
#### Approach 1
Here, we have two choices,
![[Maximum number of points-1675608311800.jpeg]]
So we perform those choices

>Q: How do we store the best choice
>A: At terminal step, we update the best choice to the globally created array. Also while performing recursion, we take care to reset our choices
>![[Maximum number of points-1675608439426.jpeg]]
>before moving to the next step. This is an important step for backtracking problems

###### Code
```java
class Solution {

int maxScore = 0;

int[] res = null;

public void solve(int numArrows, int[] aliceArrows, int[] bobArrows, int index, int score){

if(index == aliceArrows.length || numArrows <= 0){

if(score > maxScore){

maxScore = score;

res = bobArrows.clone();

res[0] += numArrows;

}

return;

}

if(numArrows > aliceArrows[index]){

bobArrows[index] = aliceArrows[index] + 1;

solve(numArrows - aliceArrows[index] - 1, aliceArrows, bobArrows, index + 1, score + index);

bobArrows[index] = 0;

}

solve(numArrows, aliceArrows, bobArrows, index + 1, score);

}

public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {

solve(numArrows, aliceArrows, new int[12], 0, 0);

return res;

}

}
```

