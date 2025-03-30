class Solution {
    static boolean equalPartition(int arr[]) {
        // code here
        int sum = 0;
        for(int num : arr){
            sum += num;
        }
        
        if(sum % 2 != 0){
            return false;
        }
        sum = sum/2;

        int n = arr.length;
        boolean[] prev = new boolean[sum + 1];
        boolean[] curr = new boolean[sum + 1];
        
        prev[0] = true;
        for(int i=1; i<=n; i++){
            for(int j=0; j<=sum; j++){
                if(j < arr[i - 1]){
                    curr[j] = prev[j];
                }
                else{
                    curr[j] = (prev[j] || prev[j - arr[i - 1]]);
                }
            }
            for(int j=0; j<=sum; j++){
                prev[j] = curr[j];
            }
        }
        return prev[sum];
    }
}