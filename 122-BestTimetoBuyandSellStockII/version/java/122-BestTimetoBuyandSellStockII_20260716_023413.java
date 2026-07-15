// Last updated: 7/16/2026, 2:34:13 AM
1class Solution {
2    public int maxProfit(int[] prices) {
3        
4        int n = prices.length;
5
6        int[][] dp = new int[n+1][2];
7
8        for(int i=n-1;i>=0;i--) {
9            dp[i][0] = Math.max(dp[i+1][0], dp[i+1][1] - prices[i]);
10
11            dp[i][1] = Math.max(dp[i+1][1], dp[i+1][0] + prices[i]);
12        }
13        return dp[0][0];
14    }
15}