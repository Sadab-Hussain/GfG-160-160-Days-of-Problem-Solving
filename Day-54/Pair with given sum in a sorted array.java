class Solution {
    int countPairs(int arr[], int target) {
        // Complete the function
        int n = arr.length, res = 0;
        int left = 0, right = n - 1;
        
        while(left < right){
            int sum = arr[left] + arr[right];
            
            if(sum < target){
                left++;
            }
            else if(sum > target){
                right--;
            }
            else{
                int cnt1 = 0, cnt2 = 0;
                int ele1 = arr[left], ele2 = arr[right];
                
                while(left <= right && arr[left] == ele1){
                    left++;
                    cnt1++;
                }
                
                while(left <= right && arr[right] == ele2){
                    right--;
                    cnt2++;
                }
                
                if(ele1 == ele2){
                    res += (cnt1 * (cnt1 - 1)) / 2;
                }
                else{
                    res += (cnt1 * cnt2);
                }
            }
        }
        return res;
    }
}
