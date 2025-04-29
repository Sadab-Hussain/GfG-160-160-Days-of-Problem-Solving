class Solution {
    static class Pair implements Comparable<Pair> {
        int node, dist;
        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
        public int compareTo(Pair other) {
            return this.dist - other.dist;
        }
    }

    public int findMinCycle(int V, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }
        int minCycle = Integer.MAX_VALUE;
        
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj.get(u).removeIf(p -> p.node == v && p.dist == w);
            adj.get(v).removeIf(p -> p.node == u && p.dist == w);
            
            int[] dist = new int[V];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[u] = 0;
            
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            pq.offer(new Pair(u, 0));
            
            while (!pq.isEmpty()) {
                Pair p = pq.poll();
                int curr = p.node;
                int d = p.dist;
                for (Pair nei : adj.get(curr)) {
                    if (dist[nei.node] > d + nei.dist) {
                        dist[nei.node] = d + nei.dist;
                        pq.offer(new Pair(nei.node, dist[nei.node]));
                    }
                }
            }
            
            if (dist[v] != Integer.MAX_VALUE) {
                minCycle = Math.min(minCycle, dist[v] + w);
            }
            
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }
        return minCycle == Integer.MAX_VALUE ? -1 : minCycle;
    }
}