class Solution {
    class Graph{
        private List<int[]> edgeList;
        private int V;
        
        public Graph(int V){
            this.V = V;
            edgeList = new ArrayList<>();
        }
    
        public void addEdge(int x, int y, int w){
            edgeList.add(new int[] {w, x, y});
        }
    
        public int krusksalMST(){
            edgeList.sort(Comparator.comparingInt(a -> a[0]));
            DSV s = new DSV(V);
            
            int ans = 0, count = 0;
            for(int[] edge : edgeList){
                int w = edge[0];
                int x = edge[1];
                int y = edge[2];
                
                if(s.find(x) != s.find(y)){
                    s.unite(x, y);
                    ans += w;
                    count++;
                }
                if(count == V - 1) break;
            }
            return ans;
        }
    }
    
    class DSV{
        int[] parent , rank;
        
        public DSV(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i=0; i<n; i++){
                parent[i] = i;
                rank[i] = 0;
            }
        }
        public int find(int x){
            if(parent[x] != x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        public void unite(int x, int y){
            int xr = find(x);
            int yr = find(y);
            
            if(xr == yr) return;
            
            if(rank[xr] < rank[yr]){
                parent[xr] = yr;
            }
            else if(rank[yr] < rank[xr]){
                parent[yr] = xr;
            }
            else{
                parent[yr] = xr;
                rank[xr]++;
            }
        }
    }
    
    public int minCost(int[][] houses) {
        // code here
        int n = houses.length;
        Graph g = new Graph(n);
        
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int cost = Math.abs(houses[i][0] - houses[j][0]) + 
                            Math.abs(houses[i][1] - houses[j][1]);
                g.addEdge(i, j, cost);
            }
        }
        return g.krusksalMST();
    }
}