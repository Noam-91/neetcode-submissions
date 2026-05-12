class Solution {
    public int maxProfit(int[] prices) {
        int[] min = new int[prices.length];
        min[0] = prices[0];
        int maxPf = 0;
        for(int i=1;i<prices.length;i++){
            min[i] = Math.min(prices[i],min[i-1]);
            maxPf = Math.max(maxPf, prices[i]-min[i]);
        }
        return maxPf;
    }
}
