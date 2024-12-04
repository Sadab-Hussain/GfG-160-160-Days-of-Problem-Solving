class Solution {
    public int maximumProfit(int prices[]) {
        // Code here
        int minsofar = prices[0];
        int res = 0;
        
        for(int i=1; i<prices.length; i++){
            minsofar = Math.min(minsofar, prices[i]);
            res = Math.max(res, prices[i] - minsofar);
        }
        return res;
    }
}
