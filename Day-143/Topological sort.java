class Solution {
    private static void topologicalSortUtil(int V, List<Integer>[] adj, 
                                   boolean[] visited, Stack<Integer> stack){
                                       
        visited[V] = true;
        for(int i : adj[V]){
            if(!visited[i]){
                topologicalSortUtil(i, adj, visited, stack);
            }
        }
        stack.push(V);
    }
    
    static List<Integer>[] constructadj(int V, int [][] edges){
        List<Integer>[] adj = new ArrayList[V];
        
        for(int i=0; i<V; i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int [] edge : edges){
            adj[edge[0]].add(edge[1]);
        }
        return adj;
    }
    
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[V];
        
        List<Integer>[] adj = constructadj(V, edges);
        for(int i=0; i<V; i++){
            if(!visited[i]){
                topologicalSortUtil(i, adj, visited, st);
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        int index = 0;
        while(!st.isEmpty()){
            res.add(st.pop());
        }
        return res;
    }
}