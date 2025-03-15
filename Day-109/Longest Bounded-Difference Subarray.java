class Solution {

    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        // code here
        Deque<Integer> maxQ = new LinkedList<>();
        Deque<Integer> minQ = new LinkedList<>();
        
        int n = arr.length, start = 0, end = 0;
        
        int resStart = 0, resEnd = 0;
        while(end < n){
            while(!minQ.isEmpty() && arr[minQ.peekLast()] > arr[end]){
                minQ.pollLast();
            }
            minQ.addLast(end);
            
            while(!maxQ.isEmpty() && arr[maxQ.peekLast()] < arr[end]){
                maxQ.pollLast();
            }
            maxQ.addLast(end);
            
            while(arr[maxQ.peekFirst()] - arr[minQ.peekFirst()] > x){
                if(start == minQ.peekFirst()){
                    minQ.pollFirst();
                }
                if(start == maxQ.peekFirst()){
                    maxQ.pollFirst();
                }
                start += 1;
            }
            
            if(end - start > resEnd - resStart){
                resStart = start;
                resEnd = end;
            }
            end += 1;
        }
        ArrayList<Integer>  res = new ArrayList<>();
        for(int i=resStart; i<=resEnd; i++){
            res.add(arr[i]);
        }
        return res;
    }
}