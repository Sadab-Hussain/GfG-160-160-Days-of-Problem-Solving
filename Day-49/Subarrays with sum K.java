class Solution {
    public int countSubarrays(int arr[], int k) {
        // code here
        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        
        int res = 0, currSum = 0;
        
        for(int i=0; i<arr.length; i++){
            currSum += arr[i];
            
            if(currSum == k){
                res++;
            }
            
            if(prefixSum.containsKey(currSum - k)){
                res += prefixSum.get(currSum - k);
            }
            
            prefixSum.put(currSum, prefixSum.getOrDefault(currSum, 0) + 1);
        }
        return res;
    }
}
