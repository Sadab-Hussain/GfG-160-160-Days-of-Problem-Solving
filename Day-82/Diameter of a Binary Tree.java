class Solution {
    static int daimeterRecur(Node root, int[] res){
        if(root == null){
            return 0;
        }
        
        int lHeight = daimeterRecur(root.left, res);
        int rHeight = daimeterRecur(root.right, res);
        
        res[0] = Math.max(res[0], lHeight + rHeight);
        
        return 1 + Math.max(lHeight , rHeight);
    }
    
    int diameter(Node root) {
        // Your code here
        int[] res = new int[1];
        daimeterRecur(root, res);
        return res[0];
    }
}