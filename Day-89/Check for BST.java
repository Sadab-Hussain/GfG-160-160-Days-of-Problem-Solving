class Solution {
    static boolean inOrder(Node root, int[] prev){
        if(root == null){
            return true;
        }
        
        if(!inOrder(root.left, prev)){
            return false;
        }
        
        if(prev[0] >= root.data){
            return false;
        }
        
        prev[0] = root.data;
        
        return inOrder(root.right, prev);
    }
    
    // Function to check whether a Binary Tree is BST or not.
    boolean isBST(Node root) {
        // code here.
        int[] prev = {Integer.MIN_VALUE};
        return inOrder(root, prev);
    }
}