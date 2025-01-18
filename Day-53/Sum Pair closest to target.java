class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        // code here
        int n = arr.length;
        Arrays.sort(arr);
        
        List<Integer> res = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        
        int left = 0, right = n - 1;
        
        while(left < right){
            int sum = arr[left] + arr[right];
            
            if(Math.abs(target - sum) < minDiff){
                minDiff = Math.abs(target - sum);
                res = Arrays.asList(arr[left], arr[right]);
            }
            
            if(sum < target){
                left++;
            }
            else if(sum > target){
                right--;
            }
            else{
                return res;
            }
        }
        return res;
    }
}
