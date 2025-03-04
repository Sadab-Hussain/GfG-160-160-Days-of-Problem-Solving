class Solution {
    public ArrayList<Double> getMedian(int[] arr) {
        // code here
        PriorityQueue<Integer> lMaxHeap = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> rMinHeap = new PriorityQueue<>();
        
        ArrayList<Double> res = new ArrayList<>();
        
        for(int i=0; i<arr.length; i++){
            lMaxHeap.add(arr[i]);
            
            int temp = lMaxHeap.poll();
            rMinHeap.add(temp);
            
            if(rMinHeap.size() > lMaxHeap.size()){
                temp = rMinHeap.poll();
                lMaxHeap.add(temp);
            }
            
            double median;
            if(lMaxHeap.size() != rMinHeap.size()){
                median = lMaxHeap.peek();
            }
            else{
                median = (lMaxHeap.peek() + rMinHeap.peek()) / 2.0;
            }
            res.add(median);
        }
        return res;
    }
}