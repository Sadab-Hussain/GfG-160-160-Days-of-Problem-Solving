class Solution {
    // Function to count the number of possible triangles.
    static int countTriangles(int arr[]) {
        // code here
        Arrays.sort(arr);
        int res = 0, n = arr.length;
        
        for(int i=2; i<n; i++){
            int left = 0, right = i - 1;
            
            while(left < right){
                if(arr[left] + arr[right] > arr[i]){
                    res += right - left;
                    right--;
                }
                else{
                    left++;
                }
            }
        }
        return res;
    }
}
