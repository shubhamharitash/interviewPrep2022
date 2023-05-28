## Problem Statement
To compute shortest path between all pairs(all source and destiunations).
https://www.youtube.com/watch?v=oNI0rf2P9gE

## Approaches
#### Approach 1
![[All Pair Shortest Path(Floyd Warshall's Algorithm)-1679228666497.jpeg]]
This algorithm also works in case of -ve edges.
Time complexity: O(V^3)

###### Code
```java
class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        int V = matrix.length;
 
        for(int k=0; k<V; k++){
            for(int i=0; i<V; i++){
                for(int j=0; j<V; j++){
                    if(i==j)
                        matrix[i][j] = 0;
                    else if(matrix[i][k]!=-1 && matrix[k][j]!=-1){
                        int temp = matrix[i][j]==-1 ? (int)(1e9):matrix[i][j];
                        matrix[i][j] = Math.min(temp, matrix[i][k] + matrix[k][j]);
                    }
                }
            }
        }
    }
}
```