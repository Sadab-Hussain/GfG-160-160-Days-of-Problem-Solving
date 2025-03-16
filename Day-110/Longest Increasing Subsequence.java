class Solution {
    static int lis(int arr[]) {
        // code here
        int n = arr.length;
        List<Integer> res = new ArrayList<>();
        
        res.add(arr[0]);
        for(int i=1; i<n; i++){
            if(arr[i] > res.get(res.size() - 1)){
                res.add(arr[i]);
            }
            else{
                int low = Collections.binarySearch(res, arr[i]);
                
                if(low < 0){
                    low = -(low + 1);
                }
                res.set(low, arr[i]);
            }
        }
        return res.size();
    }
}