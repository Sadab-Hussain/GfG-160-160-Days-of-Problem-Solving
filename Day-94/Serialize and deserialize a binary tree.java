class Tree {
    static void serializePreOrder(Node root, ArrayList<Integer> arr){
        if(root == null){
            arr.add(-1);
            return;
        }
        arr.add(root.data);
        
        serializePreOrder(root.left, arr);
        serializePreOrder(root.right, arr);
    }

    public ArrayList<Integer> serialize(Node root) {
        // code here
        ArrayList<Integer> arr = new ArrayList<>();
        serializePreOrder(root, arr);
        return arr;
    }
    
    static Node deserializePreOrder(int[] i, ArrayList<Integer> arr){
        if(arr.get(i[0]) == -1){
            i[0]++;
            return null;
        }
        
        Node root = new Node(arr.get(i[0]));
        i[0]++;
        
        root.left = deserializePreOrder(i, arr);
        root.right = deserializePreOrder(i, arr);
        
        return root;
    }

    public Node deSerialize(ArrayList<Integer> arr) {
        // code here
        int [] i = {0};
        return deserializePreOrder(i, arr);
    }
    
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
            
            System.out.print(curr.data +" ");
            q.add(curr.left);
            q.add(curr.right);
            if(curr.left != null || curr.right != null){
                nonNull++;
            }
        }
    }
};