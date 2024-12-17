class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(int[] arr) {
        int lo = 0, mid = 0, hi = arr.length - 1;

        while (mid <= hi) {
            switch (arr[mid]) {
                case 0: 
                    swap(arr, lo, mid);
                    lo++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(arr, mid, hi);
                    hi--;
                    break;
            }
        }
    }
    
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
