class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int s, int t) {
        adj.get(s).add(t);
        adj.get(t).add(s);
    }
    
    public static void dfsRec(ArrayList<ArrayList<Integer>> adj, boolean[] visited, 
                            int s, ArrayList<Integer> res){
        
        visited[s] = true;
        res.add(s);
        
        for(int i: adj.get(s)){
            if(!visited[i]){
                dfsRec(adj, visited, i, res);
            }
        }
    }
    
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[adj.size()];
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i=0; i<adj.size(); i++){
            if(!visited[i]){
                dfsRec(adj, visited, i, res);
            }
        }
        return res;
    }
}