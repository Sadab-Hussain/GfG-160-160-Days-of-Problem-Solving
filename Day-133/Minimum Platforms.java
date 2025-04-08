class Solution {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    static int findPlatform(int arr[], int dep[]) {
        // add your code here
        int n = arr.length;
        int res = 0;
        
        int maxDep = dep[0];
        for(int i=1; i<n; i++){
            maxDep = Math.max(maxDep, dep[i]);
        }
        
        int [] v = new int[maxDep + 2];
        for(int i=0; i<n; i++){
            v[arr[i]]++;
            v[dep[i] + 1]--;
        }
        
        int count = 0;
        for(int i=0; i<=maxDep; i++){
            count += v[i];
            res = Math.max(res, count);
        }
        return res;
    }
}