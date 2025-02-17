class Solution {
    static void levelOrder(Node node){
        if(node == null){
            System.out.print("N ");
            return;
        }
        
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        
        while(!q.isEmpty()){
            Node curr = q.poll();
            
            if(curr == null){
                System.out.print("N ");
                continue;
            } 
            System.out.print(curr.data +" ");
            q.add(curr.left);
            q.add(curr.right);
        }
    }
    // Function to convert a binary tree into its mirror tree.
    void mirror(Node node) {
        // Your code here
        if(node == null){
            return;
        }
        
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        
        while(!q.isEmpty()){
            Node curr = q.poll();
            
            Node temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
            
            if(curr.left != null){
                q.add(curr.left);
            }
            if(curr.right != null){
                q.add(curr.right);
            }
        }
    }
}