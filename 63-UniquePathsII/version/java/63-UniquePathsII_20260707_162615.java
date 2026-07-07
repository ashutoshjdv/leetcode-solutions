// Last updated: 7/7/2026, 4:26:15 PM
1class Solution {
2    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
3        int m = obstacleGrid.length;
4        int n = obstacleGrid[0].length;
5
6        int[][] dp = new int[m][n];
7
8        dp[m-1][n-1] = 1;
9
10        for(int i=m-1;i>=0;i--) {
11            for(int j=n-1; j>=0;j--) {
12
13                if(obstacleGrid[i][j] == 1) {
14                    dp[i][j] = 0;
15                    continue;
16                }
17
18                if(i == m-1 && j == n-1) continue;
19
20                int right = 0;
21                int bottom = 0;
22
23                
24
25                if(i+1 <= m-1) bottom = dp[i+1][j];
26
27                if(j+1 <= n-1) right = dp[i][j+1];
28
29                dp[i][j] = right + bottom;
30            }
31        }
32
33        return dp[0][0];
34    }
35}