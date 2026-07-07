// Last updated: 7/7/2026, 3:55:11 PM
1class Solution {
2    public int uniquePaths(int m, int n) {
3        int[][] dp = new int[m][n];
4
5        dp[m-1][n-1] = 1;
6
7        for(int i=m-1; i>=0;i--) {
8            for(int j=n-1; j>=0;j--) {
9
10                if(i == m-1 && j == n-1) continue;
11
12                int down =0;
13                int right =0;
14
15                if(i+1 <= m-1)  down = dp[i+1][j];
16
17                if(j+1 <= n-1) right = dp[i][j+1];
18
19                dp[i][j] = down + right; 
20
21            }
22        }
23
24        return dp[0][0];
25    }
26}