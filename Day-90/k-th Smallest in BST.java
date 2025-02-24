class Solution {
    static int kthSmallestRec(Node root, int k, int[] cnt){
        if(root == null){
            return -1;
        }
        
        int left = kthSmallestRec(root.left, k, cnt);
        
        if(left != -1){
            return left;
        }
        cnt[0]++;
        
        if(cnt[0] == k){
            return root.data;
        }
        
        int right = kthSmallestRec(root.right, k, cnt);
        return right;
    }
    // Return the Kth smallest element in the given BST
    public int kthSmallest(Node root, int k) {
        // Write your code here
        int[] cnt = {0};
        
        return kthSmallestRec(root, k, cnt);
    }
}