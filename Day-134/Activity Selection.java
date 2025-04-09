class Solution {
    public int activitySelection(int[] start, int[] finish) {
        // code here.
        int n = start.length, res = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0]));
            
        for(int i=0; i<n; i++){
            pq.add(new int[]{finish[i], start[i]});
        }
        
        int finishTime = -1;
        while(!pq.isEmpty()){
            int [] activity = pq.poll();
            if(activity[1] > finishTime){
                finishTime = activity[0];
                res++;
            }
        }
        return res;
    }
}