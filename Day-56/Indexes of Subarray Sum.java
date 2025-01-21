class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // code here
        int s = 0, e = 0;
        ArrayList<Integer> res = new ArrayList<>();
        
        int cur = 0;
        for(int i=0; i<arr.length; i++){
            cur += arr[i];
            
            if(cur >= target){
                e = i;
                
                while(cur > target && s < e){
                    cur -= arr[s];
                    s++;
                }
                
                if(cur == target){
                    res.add(s + 1);
                    res.add(e + 1);
                    return res;
                }
            }
        }
        res.add(-1);
        return res;
    }
}