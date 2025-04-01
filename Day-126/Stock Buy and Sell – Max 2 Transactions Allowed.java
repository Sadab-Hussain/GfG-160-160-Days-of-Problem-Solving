class Solution {
    public static int maxProfit(int[] prices) {
        // code here
        int n = prices.length;
        if(n == 0){
            return 0;
        }
        
        int firstBuy = Integer.MIN_VALUE ,firstSell = 0;
        int secondBuy = Integer.MIN_VALUE, secondSell = 0;
        
        for(int i=0; i<n; i++){
            firstBuy = Math.max(firstBuy, -prices[i]);
            firstSell = Math.max(firstSell, firstBuy + prices[i]);
            secondBuy = Math.max(secondBuy, firstSell - prices[i]);
            secondSell = Math.max(secondSell, secondBuy + prices[i]);
        }
        return secondSell;
    }
}