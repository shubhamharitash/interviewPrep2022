#### Equivalence Relations and Equivalence Classes
https://unacademy.com/content/cbse-class-12/study-material/mathematics/equivalence-relations-and-classes/

###### Equivalence Relation
![[Disjoint Sets-1678814557835.jpeg]]

###### Equivalence Class
![[Disjoint Sets-1678814475138.jpeg]]

![[Disjoint Sets-1678815418440.jpeg]]

#### Disjoint sets ADT
1) makeset(x): new set with ele x
2) union(x,y): {x},{y} -> {x,y}
3) find(x): find set contaning element x

#### Ways of implementation
https://leetcode.com/discuss/general-discussion/1072418/Disjoint-Set-Union-(DSU)Union-Find-A-Complete-Guide
![[Disjoint Sets-1678815849619.jpeg]]

###### Fast FIND Implementation
![[Disjoint Sets-1678922952719.jpeg]]

###### Fast UNION(Slow Find)
![[Disjoint Sets-1678818387826.jpeg]]

###### Fast UNION(Quick Find)
1) Union by size
Code
```java
class Solution{
	private int[] arr;
	private int[] size;
	Solution(int n){
	// makeset operation
		arr = new int[n];
		size = new int[n];
		for(int i=0; i<n;i++){
			arr[i] = i;
			size[i] = 1;
		}
	}

	public static int find(int ele){
		if(ele == arr[ele])
			return ele;
		arr[ele] = find(arr[ele]);
		return arr[ele];
	}

	public static void unionBySize(int u, int v){
		if(arr[u] == arr[v])
			return;
		if(size[u]<size[v]){
			arr[u] = v;
			size[v] += size[u];
		} else {
			arr[v] = u;
			size[u] += size[v];
		}
	}
}
```
Time Complexity: O(logn) 

2) Union by rank
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
```
Time Complexity: O(logn)