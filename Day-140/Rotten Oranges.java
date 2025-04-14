class Solution {
    static boolean isSafe(int i, int j, int n, int m){
        return (i >= 0 && i<n && j>=0 && j<m);
    }
    
    public int orangesRotting(int[][] mat) {
        // Code here
        int n = mat.length;
        int m = mat[0].length;
        
        int [][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] == 2){
                    q.add(new int[] {i, j});
                }
            }
        }
        
        int elapsedTime = 0;
        while(!q.isEmpty()){
            elapsedTime++;
            
            int len = q.size();
            while(len--> 0){
                int curr[] = q.poll();
                int i = curr[0];
                int j = curr[1];
                
                for(int[] dir : directions){
                    int x = i + dir[0];
                    int y = j + dir[1];
                    
                    if(isSafe(x, y, n, m) && mat[x][y] == 1){
                        mat[x][y] = 2;
                        q.add(new int[] {x, y});
                    } 
                }
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] == 1){
                    return -1;
                }
            }
        }
        return Math.max(0, elapsedTime - 1);
    }
}