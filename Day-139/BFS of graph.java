class Solution {
    static  ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj, 
                                int s, boolean[] visited, ArrayList<Integer> res) {
        Queue<Integer> q = new LinkedList<>();
        
        visited[s] = true;
        q.add(s);
        
        while(!q.isEmpty()){
            int curr = q.poll();
            res.add(curr);
            
            for(int x : adj.get(curr)){
                if(!visited[x]){
                    visited[x] = true;
                    q.add(x);
                }
            }
        }
        return res;
    }
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        
        for(int i=0; i<adj.size(); i++){
            if(!visited[i]){
               bfs(adj, i, visited, res); 
            }
        }
        return res;
    }
}