## Problem Statement
https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/

## Approaches
#### Approach 1(Dijikstra)
It is a greedy approach
Time Complexity: ElogV

We have a 
dist[] -> initialize to infinity except source
visited[] -> initialize to false
We use a minHeap to always get node with shortest distance.
For all neighbours 
	If visited then skip
	else 
		compute and update `distance[neighbour]`
		push pq.push((neighbour,`distance[neighbour]`))
return dist array

###### Code
```java
class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int src)
    {
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.get(1)));
        ArrayList<Integer> root = new ArrayList<>();
        root.add(src);
        root.add(0);
        dist[src] = 0;
        pq.add(root);
        while(!pq.isEmpty()){
            ArrayList<Integer> temp = pq.remove();
            if(visited[temp.get(0)])
                continue;
            visited[temp.get(0)] = true;
            adj.get(temp.get(0)).forEach(node -> {
                if(!visited[node.get(0)]){
                    int newDist = dist[temp.get(0)] + node.get(1);
                    if(newDist < dist[node.get(0)])
                        dist[node.get(0)] = newDist;
                    ArrayList<Integer> newNode = new ArrayList<>();
                    //Imp step :)
                    newNode.add(node.get(0));
                    newNode.add(dist[node.get(0)]);
                    pq.add(newNode);
                }
            });
        }
        return dist;
    }
}
```