// Last updated: 7/16/2026, 10:04:37 PM
1class Solution {
2    public int maxProfit(int[] prices) {
3        int n = prices.length;
4
5        int[][][] dp = new int[n+1][3][2];
6
7        for(int i=n-1; i>=0;i--) {
8            for(int j=1; j>=0;j--) {
9                
10                dp[i][j][0] = Math.max(dp[i+1][j][0], dp[i+1][j][1] - prices[i]);
11
12                dp[i][j][1] = Math.max(dp[i+1][j][1], dp[i+1][j+1][0] + prices[i]);
13            }
14        }
15
16        return dp[0][0][0];
17    }
18}