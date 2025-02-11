class Solution {
    static void nQueenProb(int j, int n, ArrayList<Integer> board, boolean[] rows, 
            boolean[] daig1, boolean[] daig2, ArrayList<ArrayList<Integer>> res){
                    
        if(j > n){
            res.add(new ArrayList<>(board));
            return;
        }
        
        for(int i=1; i<=n; i++){
            if(!rows[i] && !daig1[i + j] && !daig2[i - j + n]){
                rows[i] = daig1[i + j] = daig2[i - j + n] = true;
                board.add(i);
                
                nQueenProb(j + 1, n, board, rows, daig1, daig2, res);
                
                board.remove(board.size() - 1);
                rows[i] = daig1[i + j] = daig2[i - j + n] = false;
            }
        }
    }
    
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> board = new ArrayList<>();
        
        boolean[] rows = new boolean[n + 1];
        
        boolean[] daig1 = new boolean[2 * n + 1];
        boolean[] daig2 = new boolean[2 * n + 1];
        
        nQueenProb(1, n, board, rows, daig1, daig2, res);
        return res;
    }
}
