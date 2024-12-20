class Solution {
    public List<int[]> mergeOverlap(int[][] arr) {
        // Code here
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> result = new ArrayList<>();

        int[] currentInterval = arr[0];
        result.add(currentInterval);
        
        for (int i = 1; i < arr.length; i++) {

            if (currentInterval[1] >= arr[i][0]) {
                currentInterval[1] = Math.max(currentInterval[1], arr[i][1]);
                
            } else {
                currentInterval = arr[i];
                result.add(currentInterval);
            }
        }
        
        return result; 
    }
}
