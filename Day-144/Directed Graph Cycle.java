class Solution {
    static List<Integer>[] constructadj(int V, int[][] edges){
        List<Integer>[] adj = new ArrayList[V];
        
        for(int i=0; i<V; i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int[] edge : edges){
            adj[edge[0]].add(edge[1]);
        }
        return adj;
    }
    
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        List<Integer>[] adj = constructadj(V, edges);
        
        int[] indegree = new int[V];
        
        Queue<Integer> q = new LinkedList<>();
         
        int visited = 0;
        
        for(int u=0; u<V; u++){
            for(int v : adj[u]){
                indegree[v]++;
            }
        }
        
        for(int u=0; u<V; u++){
            if(indegree[u] == 0){
                q.offer(u);
            }
        }
        
        while(!q.isEmpty()){
            int u = q.poll();
            visited++;
            
            for(int v : adj[u]){
                indegree[v]--;
                if(indegree[v] == 0){
                    q.offer(v);
                }
            }
        }
        return visited !=V;
    }
}