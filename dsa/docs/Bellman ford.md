## Problem Statement
Identify if negative weight cycke exist or not.

## Approaches
#### Approach 1
![[Bellman ford-1679135917874.jpeg]]

###### Code
```java
class Solution
{
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        int[] dist = new int[n];
        Arrays.fill(dist, (int)1e9);
        dist[0] = 0;
        for(int i=1; i<n; i++){
            for(int j=0; j<edges.length; j++){
                int newDist = dist[edges[j][0]] + edges[j][2];
                if(dist[edges[j][1]]>newDist)
                    dist[edges[j][1]] = newDist;
            }
        }
        for(int i=1; i<n; i++){
            for(int j=0; j<edges.length; j++){
                int newDist = dist[edges[j][0]] + edges[j][2];
                if(dist[edges[j][1]]>newDist)
                    return 1;
            }
        }
        return 0;
    }
}
```