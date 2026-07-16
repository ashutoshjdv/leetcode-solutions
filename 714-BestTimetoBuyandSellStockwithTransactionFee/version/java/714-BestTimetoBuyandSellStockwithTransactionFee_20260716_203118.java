// Last updated: 7/16/2026, 8:31:18 PM
1class Solution {
2    public int maxProfit(int[] prices, int fee) {
3        int n = prices.length;
4
5        int[][] dp = new int[n+1][2];
6
7        for(int i=n-1; i>=0;i--) {
8
9            dp[i][0] = Math.max(dp[i+1][0], dp[i+1][1]-prices[i]);
10
11            dp[i][1] = Math.max(dp[i+1][1], dp[i+1][0]+prices[i]-fee);
12        }
13
14        return dp[0][0];
15    }
16}