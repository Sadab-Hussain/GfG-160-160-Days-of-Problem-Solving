class Solution {
    public void nextPermutation(int[] arr) {
        int n = arr.length;
        int pivot = -1;
        
        // Find the pivot: the first element from the right that is smaller than the next element.
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                pivot = i;
                break;
            }
        }
        
        // If no pivot is found, reverse the array to get the smallest permutation.
        if (pivot == -1) {
            reverse(arr, 0, n - 1);
            return;
        }
        
        // Find the smallest element in the suffix that is larger than the pivot and swap them.
        for (int i = n - 1; i > pivot; i--) {
            if (arr[i] > arr[pivot]) {
                swap(arr, i, pivot);
                break;
            }
        }
        
        // Reverse the suffix to get the next lexicographical permutation.
        reverse(arr, pivot + 1, n - 1);
    }

    // Helper method to reverse a portion of the array.
    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start++, end--);
        }
    }

    // Helper method to swap two elements in the array.
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
