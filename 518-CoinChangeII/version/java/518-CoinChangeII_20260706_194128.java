// Last updated: 7/6/2026, 7:41:28 PM
1class Solution {
2    public int change(int amount, int[] coins) {
3        
4        int n = coins.length;
5
6        int[][] dp = new int[n+1][amount+1];
7
8        for(int i =0; i<=n; i++) {
9            dp[i][0] = 1;
10        }
11
12        for(int i=n-1; i>=0;i--) {
13            for(int j=0; j<=amount; j++) {
14
15                int skip = dp[i+1][j];
16
17                int take = coins[i] <= j ? dp[i][j-coins[i]] : 0 ;
18
19                dp[i][j] = skip + take;
20            }
21        }
22
23        return dp[0][amount];
24    }
25}