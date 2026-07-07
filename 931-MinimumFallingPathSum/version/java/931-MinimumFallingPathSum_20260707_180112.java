// Last updated: 7/7/2026, 6:01:12 PM
1class Solution {
2    public int minFallingPathSum(int[][] matrix) {
3        int m = matrix.length;
4        int n = matrix[0].length;
5
6        int[][] dp = new int[m][n];
7
8        for(int[] dpRow : dp) {
9            Arrays.fill(dpRow, Integer.MAX_VALUE);
10        }
11
12        int minResult = Integer.MAX_VALUE;
13
14        for(int i=m-1; i>=0; i--) {
15            for(int j=n-1; j>=0; j--) {
16
17                int left = Integer.MAX_VALUE;
18                int bottom = Integer.MAX_VALUE;
19                int right = Integer.MAX_VALUE;
20
21                if(i == m-1) {
22                    dp[i][j] = matrix[i][j];
23                    if(i == 0) {
24                        minResult = Math.min(minResult, dp[i][j]);
25                    }
26                    continue;
27                }
28
29                if( i+1 <= m-1) {
30                    bottom = dp[i+1][j];
31
32                    if(j-1 >=0) left = dp[i+1][j-1];
33
34                    if(j+1 <= n-1) right = dp[i+1][j+1];
35                }
36
37                dp[i][j] = matrix[i][j] + Math.min(bottom, Math.min(right, left));
38
39                if(i == 0) {
40                    minResult = Math.min(minResult, dp[i][j]);
41                }
42            }
43        }
44
45        return minResult;
46    }
47}