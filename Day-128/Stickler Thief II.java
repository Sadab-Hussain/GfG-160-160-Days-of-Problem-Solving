class Solution {
    static int maxValTab(int[] arr, int x, int y){
        int prev2 = arr[x];
        int prev1 = Math.max(arr[x], arr[x + 1]);
        
        for(int i=x+2; i<=y; i++){
            int take = arr[i] + prev2, noTake = prev1;
            
            int curr = Math.max(take, noTake);
            
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
    
    int maxValue(int[] arr) {
        // code here
        int n = arr.length;
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return arr[0];
        }
        
        int res = 0;
        
        res = Math.max(res, maxValTab(arr, 0, n-2));
        res = Math.max(res, maxValTab(arr, 1, n-1));
        
        return res;
    }
}