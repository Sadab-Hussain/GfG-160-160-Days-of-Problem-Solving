class Solution {
    static void printLevelOrder(Node root){
        if(root == null){
            System.out.print("N ");
            return;
        }
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int nonNull = 1;
        
        while(!q.isEmpty() && nonNull > 0){
            Node curr = q.poll();
            
            if(curr == null){
                System.out.print("N ");
                continue;
            }
            nonNull--;
            
            System.out.print(curr.data+ " ");
            q.add(curr.left);
            q.add(curr.right);
            if(curr.left != null){
                nonNull++;
            }
            if(curr.right != null){
                nonNull++;
            }
        }
    }
    
    static Node buildTreeRecur(Map<Integer, Integer>mp, int[] preorder, 
                            int[] preindex, int left, int right){
        if(left > right){
            return null;
        }
        
        int rootVal = preorder[preindex[0]];
        preindex[0]++;
        
        Node root = new Node(rootVal);
        
        int index = mp.get(rootVal);
        
        root.left = buildTreeRecur(mp, preorder, preindex, left, index-1);
        root.right = buildTreeRecur(mp, preorder, preindex, index+1, right);
        
        return root;
    }
    
    public static Node buildTree(int inorder[], int preorder[]) {
        // code here
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            mp.put(inorder[i], i);
        }
        
        int[] preindex = {0};
        return buildTreeRecur(mp, preorder, preindex, 0, inorder.length - 1);
    }
}
