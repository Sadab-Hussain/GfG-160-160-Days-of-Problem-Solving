class Solution {
    static HashMap<Node, Node> copies = new HashMap<>();
    
    Node cloneGraph(Node node) {
        // code here
        if(node == null) return null;
        
        if(!copies.containsKey(node)){
            Node clone = new Node(node.val);
            copies.put(node, clone);
            
            for(Node neighbor : node.neighbors){
                clone.neighbors.add(cloneGraph(neighbor));
            }
        }
        return copies.get(node);
    }
    
    public static Node buildGraph(){
        Node node1 = new Node(0);
        Node node2 = new Node(1);
        Node node3 = new Node(2);
        Node node4 = new Node(3);
        
        node1.neighbors.addAll(Arrays.asList(node2, node3));
        node2.neighbors.addAll(Arrays.asList(node1, node3));
        node3.neighbors.addAll(Arrays.asList(node1, node2, node4));
        node4.neighbors.addAll(Arrays.asList(node3));
        
        return node1;
    }
    
    public static boolean compareGraphs(Node node1, Node node2, 
                                        HashMap<Node, Node> visited){
        if(node1 == null || node2 == null){
            return node1 == node2;
        }
        
        if(node1.val != node2.val || node1 == node2){
            return false;
        }
        
        visited.put(node1, node2);
        if(node1.neighbors.size() != node2.neighbors.size()){
            return false;
        }
        
        for(int i=0; i<node1.neighbors.size(); i++){
            Node n1 = node1.neighbors.get(i);
            Node n2 = node2.neighbors.get(i);
            
            if(visited.containsKey(n1)){
                if(visited.get(n1) != n2){
                    return false;
                }
            }
            else {
                if(!compareGraphs(n1, n2, visited)){
                    return false;
                }
            }
        }
        return true;
    }
}