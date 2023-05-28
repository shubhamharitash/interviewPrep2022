## Problem Statement
https://www.geeksforgeeks.org/topological-sorting/

## Approaches
#### Approach 1(DFS)
1) Calculate indegree arr
2) for every indegree 0, calculate dfs which has a common visted to keep track of visited nodes.
3) reverse the result and return as array.

###### Code
```java
class Solution
{
    //Function to return list containing vertices in Topological order. 
    public static boolean[] visited = null;
    public static ArrayList<Integer> helper(int root, ArrayList<ArrayList<Integer>> adj){
        if(visited[root])
            return new ArrayList<>();
        visited[root] = true;
        ArrayList<Integer> res = new ArrayList<>();
        adj.get(root).forEach(e -> {
            res.addAll(helper(e, adj));
        });
        res.add(root);
        return res;
    }
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        // add your code here
        int[] indegree = new int[V];
        adj.forEach(nodes -> {
            nodes.forEach(node -> indegree[node]++);
        });
        int root=0;
        visited = new boolean[V];
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0; i<V;i++){
            if(indegree[i]==0){
                res.addAll(helper(i, adj));
            }
        }
        Collections.reverse(res);
        return res.stream().mapToInt((Integer e) -> e).toArray();
    }
}
```

#### Approach 2(BFS)
1) Calculate indegree
2) Push all nodes with indegree 0 to queue
3) Process current node
	1) add to result
	2) reduce indegree of neigbours by 1 and if any indegree becomes 0 for any of them add to queue.
4) return result

###### Code
```java
class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[V];
        boolean[] visited = new boolean[V];
        adj.forEach(nodes -> {
            nodes.forEach(node -> indegree[node]++);
        });
        for(int i=0; i<V; i++){
            if(indegree[i]==0)
                q.offer(i);
        }
        int[] res = new int[V];
        int cnt=0;
        while(!q.isEmpty()){
            int temp = q.poll();
            if(visited[temp])
                continue;
            res[cnt] = temp;
            cnt++;
            adj.get(temp).forEach(e -> {
                indegree[e]--;
                if(indegree[e]==0){
                    q.offer(e);
                } 
            });
        }
        return res;
    }
}
```

#### Usecases
![[Topological Sort-1678984936773.jpeg]]
