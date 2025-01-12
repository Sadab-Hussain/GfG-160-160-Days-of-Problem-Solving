class Solution {
    
    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        // code here
        HashSet<Integer> set = new HashSet<>();
        int res = 0;
        
        for(int val : arr){
            set.add(val);
        }
        
        for(int val : arr){
            if(set.contains(val) && !set.contains(val - 1)){
                int cur = val, cnt = 0;
                
                while(set.contains(cur)){
                    set.remove(cur);
                    cur++;
                    cnt++;
                }
                res = Math.max(res, cnt);
            }
        }
        return res;
    }
}
