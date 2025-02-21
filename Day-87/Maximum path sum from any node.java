class Solution {
    static int maxPathSum(Node root, int[] res){
        if(root == null){
            return 0;
        }
        
        int left = Math.max(0, maxPathSum(root.left, res));
        int right = Math.max(0, maxPathSum(root.right, res));
        
        res[0] = Math.max(res[0], left + right + root.data);
        
        return root.data + Math.max(left, right);
    }
    
    // Function to return maximum path sum from any node in a tree.
    int findMaxSum(Node root) {
        // your code goes here
        int[] res = {root.data};
        
        maxPathSum(root, res);
        
        return res[0];
    }
}