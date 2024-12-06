class Solution {

    // arr: input array
    // Function to find the sum of contiguous subarray with maximum sum.
    int maxSubarraySum(int[] arr) {

        // Your code here
        int res = arr[0];
        int maxEnding = arr[0];
        
        for(int i=1; i<arr.length; i++){
            maxEnding = Math.max(maxEnding + arr[i], arr[i]);
            
            res = Math.max(res, maxEnding);
        }
        return res;
    }
}