class Solution {
    public int getSecondLargest(int[] arr) {
        int res = -1, largest = 0;

        // Iterate through the array to find the largest and second largest elements
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[largest]) {
                res = largest;
                largest = i;
            } else if (arr[i] != arr[largest]) {
                if (res == -1 || arr[i] > arr[res]) {
                    res = i;
                }
            }
        }
        return (res == -1) ? -1 : arr[res];
    }
}