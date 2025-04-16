class Solution {
    static boolean isCycleUtil(int V, List<Integer>[] adj, boolean[] visited,
                                int parent){
        visited[V] = true;
        for(int i : adj[V]){
            if(!visited[i]){
                if(isCycleUtil(i, adj, visited, V)){
                    return true;
                }
            }
            else if(i != parent){
                return true;
            }
        }
        return false;
    }
    
    static List<Integer>[] constructadj(int V, int[][] edges){
        List<Integer>[] adj = new ArrayList[V];
        
        for(int i=0; i<V; i++){
            adj[i] = new ArrayList<>();
        }
        return adj;
    }
    
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        List<Integer>[] adj = constructadj(V, edges);
        
        for(int edge[] : edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        
        boolean[] visited = new boolean[V];
        for(int u=0; u<V; u++){
            if(!visited[u]){
               if(isCycleUtil(u, adj, visited, -1)){
                    return true;
               }
            }
        }
        return false;
    }
}