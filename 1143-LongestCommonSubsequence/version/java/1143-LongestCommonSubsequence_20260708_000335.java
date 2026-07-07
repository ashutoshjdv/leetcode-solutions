// Last updated: 7/8/2026, 12:03:35 AM
1class Solution {
2    public int longestCommonSubsequence(String text1, String text2) {
3        int m = text1.length();
4        int n = text2.length();
5
6        int[][] dp = new int[m+1][n+1];
7
8        for(int i=0; i<=n; i++) {
9            dp[m][i] = 0;
10        }
11        for(int i=0; i<=m; i++) {
12            dp[i][n] = 0;
13        }
14
15        for(int i=m-1; i>=0; i--) {
16            for(int j=n-1; j>=0; j--) {
17
18                if(text1.charAt(i) == text2.charAt(j)) dp[i][j] = 1 + dp[i+1][j+1];
19                else dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
20
21            }
22        }
23
24        return dp[0][0];
25    }
26}