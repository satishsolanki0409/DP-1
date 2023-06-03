// DP solution
// time = O(n)
class Solution {
    public int maxProfit(int[] prices) {
       
        // using DP
        /*
                   [7,    1,               5,                      3, 6, 4]
        profit.     0  max(0,1-7)=0   max(0, 5-buyprice) = 4     
        buyprice    7  min(7,1)=1     min(5,1) = 1
        */
        
        int buyprice = prices[0];
        int profit = 0;
        
        for (int i=1; i< prices.length; i++) {
            profit = Math.max(profit, prices[i]-buyprice);
            buyprice = Math.min(buyprice, prices[i]);
        }
    return profit;
    }
    
}


// Non-DP solution
// time = O(n)
class Solution1 {
    public int maxProfit(int[] prices) {
        
        // naive approach
        if (prices.length ==1) return 0;
        int buy = 0;
        int sell = 1;
        int profit = Math.max(0, prices[sell]-prices[buy]);
        
        while (sell<prices.length-1){
            // buy > sell
            if (prices[buy] > prices[sell]) {
                buy = sell;
            }            
            sell++;
            profit = Math.max(profit, prices[sell]-prices[buy]);
        }
        
        return profit;
    }
}
