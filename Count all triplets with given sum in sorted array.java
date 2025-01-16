class Solution {
    public int countTriplets(int[] arr, int target) {
        // Code Here
        int n = arr.length, res = 0;
        
        for(int i=0; i<n-2; i++){
            int left = i + 1, right = n - 1;
            
            while(left < right){
                int sum = arr[i] + arr[left] + arr[right];
                
                if(sum < target){
                    left++;
                }
                else if (sum > target){
                    right--;
                }
                else if (sum == target){
                    int el1 = arr[left], el2 = arr[right];
                    int cnt1 = 0, cnt2 = 0;
                    
                    while(left <= right && arr[left] == el1){
                        left++;
                        cnt1++;
                    }
                    
                    while(left <= right && arr[right] == el2){
                        right--;
                        cnt2++;
                    }
                    
                    if(el1 == el2){
                        res += (cnt1 * (cnt1 - 1)) / 2;
                    }
                    else{
                        res += (cnt1 * cnt2);
                    }
                }
            }
        }
        return res;
    }
}