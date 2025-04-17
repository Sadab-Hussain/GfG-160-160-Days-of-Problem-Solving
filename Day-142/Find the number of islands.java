class Solution {
    static void dfs(char[][] grid, int r, int c){
        int row = grid.length;
        int col = grid[0].length;
        
        if(r < 0 || c < 0 || r >= row || c >= col || grid[r][c] !='L'){
            return;
        }
        
        int [] rNbr = {-1,-1,-1,0,0,1,1,1};
        int [] cNbr = {-1,0,1,-1,1,-1,0,1};
        
        grid[r][c] = 'W';
        
        for(int i=0; i<8; i++){
            int newR = r + rNbr[i];
            int newC = c + cNbr[i];
            
            dfs(grid, newR, newC);
        }
    }
    
    public int countIslands(char[][] grid) {
        // Code here
        int row = grid.length;
        int col = grid[0].length;
        
        int count = 0;
        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                if(grid[r][c] == 'L'){
                    dfs(grid, r, c);
                    count++;
                }
            }
        }
        return count;
    }
}