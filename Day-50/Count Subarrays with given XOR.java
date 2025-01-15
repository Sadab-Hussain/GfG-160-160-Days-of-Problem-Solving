class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        int res = 0;
        HashMap<Integer,Integer> mp = new HashMap<>();
        
        int prefixXOR = 0;
        
        for(int num : arr){
            prefixXOR ^= num;
            
            res += mp.getOrDefault(prefixXOR ^ k, 0);
        
            if(prefixXOR == k){
                res++;
            }
            
            mp.put(prefixXOR, mp.getOrDefault(prefixXOR , 0) + 1);
        }
        return res;
    }
}
