// Last updated: 7/7/2026, 4:13:38 PM
1class Solution {
2    public int minPathSum(int[][] grid) {
3
4        int m = grid.length;
5        int n = grid[0].length;
6        int[][] dp = new int[m][n];
7
8        for(int i=m-1; i>=0;i--) {
9            for(int j=n-1;j>=0;j--) {
10                int right = Integer.MAX_VALUE;
11                int bottom = Integer.MAX_VALUE;
12
13                if(i+1 <= m-1) bottom = dp[i+1][j];
14
15                if(j+1 <= n-1) right = dp[i][j+1];
16
17                if(i == m-1 && j == n-1) {
18                    dp[i][j] = grid[i][j];
19                    continue;
20                }
21
22                dp[i][j] = grid[i][j] + Math.min(bottom, right);
23            }
24        }
25
26        return dp[0][0];
27    }
28}