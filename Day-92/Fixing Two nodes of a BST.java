class Solution {
    static void swap(Node a, Node b){
        int temp = a.data;
        a.data = b.data;
        b.data = temp;
    }
    
    static void correctBST(Node root, Node[] first, Node[] last, Node[] middle,
                            Node[] prev){
                            
        if(root == null){
            return;
        }    
        
        correctBST(root.left, first, last, middle, prev);
        
        if(prev[0] != null && root.data < prev[0].data){
            if(first[0] == null){
                first[0] = prev[0];
                middle[0] = root;
            }
            else{
                last[0] = root;
            }
        }
        prev[0] = root;
        correctBST(root.right, first, last, middle, prev);
    }
    
    void correctBST(Node root) {
        // code here.
        Node[] first = {null}, middle = {null}, 
                        last = {null}, prev = {null};
        
        correctBST(root, first, last, middle, prev);
        
        if(first[0] != null && last[0] != null){
            swap(first[0], last[0]);
        }
        else if(first[0] != null && middle[0] != null){
            swap(first[0], middle[0]);        
        }
    }
    
    static void printLevelOrder(Node root){
        if(root == null){
            System.out.print("N ");
            return;
        }
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        int notNull = 1;
        while(!q.isEmpty() && notNull > 0){
            Node curr = q.poll();
            
            if(curr == null){
                System.out.print("N ");
                continue;
            }
            notNull--;
            
            System.out.print(curr.data +" ");
            q.add(curr.left);
            q.add(curr.right);
            if(curr.left != null || curr.right != null){
                notNull++;
            }
        }
    }
}