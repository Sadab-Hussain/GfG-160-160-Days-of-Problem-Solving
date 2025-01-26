class Solution {
    // Function to find equilibrium point in the array.
    public static int findEquilibrium(int arr[]) {
        // code here
        int n = arr.length;
        int prefSum = 0, totalSum = 0;
        
        for(int ele : arr){
            totalSum += ele;
        }
        
        for(int pivot=0; pivot<n; pivot++){
            int suffSum = totalSum  - prefSum - arr[pivot];
            
            if(prefSum == suffSum){
                return pivot;
            }
            
            prefSum += arr[pivot];
        }
        return -1;
    }
}
