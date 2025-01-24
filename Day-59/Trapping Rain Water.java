class Solution {
    public int maxWater(int arr[]) {
        // code here
        int left = 1, right = arr.length - 2;
        int lmax = arr[left - 1], rmax = arr[right + 1];
        
        int res = 0;
        while(left <= right){
            if(rmax <= lmax){
                res += Math.max(0, rmax - arr[right]);
                rmax = Math.max(rmax, arr[right]);
                right--;
            }
            else{
                res += Math.max(0, lmax - arr[left]);
                lmax = Math.max(lmax, arr[left]);
                left++;
            }
        }
        return res;
    }
}
