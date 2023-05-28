## Problem Statement
https://www.geeksforgeeks.org/kruskals-minimum-spanning-tree-algorithm-greedy-algo-2/

## Approaches
#### Approach 1
Time Complexity: O(ElogE)

1) Sort edges array in ascending order
2) Keep on adding edges with minimum weight until V-1 edges are added. Skip any edge which creates a cycle.

>**Q: How do we find cycle?**
>A: Cycle is identified using set theory. 
>Initially each vertex is it own set. we perform union between two vertices for an edge. If both vertices are in the same set, union can't be performed else we perform the union.

###### Code
```java
class UnionByRank{
    private int[] rank;
    private int[] parent;
    private int size;
    UnionByRank(int V){
        rank = new int[V];
        parent = new int[V];
        for(int i=0; i<V; i++){
            parent[i] = i;
            rank[i] = 1;
        }
        size = V;
    }
    
    public int find(int x){
        if(x<0 || x>(size-1))
            return -1;
        if(parent[x] == x)
            return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
    
    public boolean union(int a, int b){
        int setA = find(a);
        int setB = find(b);
        if(setA==-1 || setB==-1 || setA==setB)
            return false;
        if(rank[setA] == rank[setB]){
            parent[setB] = setA;
            rank[setA]++;
        } else if(rank[setA] > rank[setB]){
            parent[setB] = setA;
        } else {
            parent[setA] = setB;
        }
        return true;
    }
}
class Solution{
    
	static int spanningTree(int V, int E, int edges[][]){
	    Arrays.sort(edges, Comparator.comparingInt(e -> e[2]));
	    int cnt = 0;
	    int sum = 0;
	    UnionByRank unionByRank = new UnionByRank(V);
	    for(int i=0; i<edges.length && cnt<V-1; i++){
	        if(unionByRank.union(edges[i][0], edges[i][1])){
	            sum += edges[i][2];
	            cnt++;
	        }
	    }
	    return sum;
	}
}
```