class Solution {
    static boolean isSafe(int[][] mat, int row, int col, int num){
        for(int x=0; x<9; x++){
            if(mat[row][x] == num){
                return false;
            }
        }
        
        for(int x=0; x<9; x++){
            if(mat[x][col] == num){
                return false;
            }
        }
        
        int startRow = row - (row % 3), startCol = col - (col % 3);
        
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(mat[i + startRow][j + startCol] == num){
                    return false;
                }
            }
        }
        return true;
    }
    
    static boolean sudukoSolveRecur(int mat[][], int row, int col){
        if(row == 8 && col == 9){
            return true;
        }
        
        if(col == 9){
            row++;
            col = 0;
        }
        
        if(mat[row][col] != 0){
            return sudukoSolveRecur(mat, row, col + 1);
        }
        
        for(int num=0; num<=9; num++){
            if(isSafe(mat, row, col, num)){
                mat[row][col] = num;
                if(sudukoSolveRecur(mat, row, col + 1)){
                    return true;
                }
                mat[row][col] = 0;
            }
        }
        return false;
    }
    
    // Function to find a solved Sudoku.
    static void solveSudoku(int[][] mat) {
        // code here
        sudukoSolveRecur(mat, 0, 0);
    }
}