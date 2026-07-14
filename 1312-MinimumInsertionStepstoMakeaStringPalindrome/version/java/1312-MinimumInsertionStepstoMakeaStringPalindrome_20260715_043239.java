// Last updated: 7/15/2026, 4:32:39 AM
1class Solution {
2    public int minInsertions(String s) {
3        int n = s.length();
4
5        int[][] dp = new int[n][n];
6
7        for(int i=n-1; i>=0; i--) {
8            for(int j=0; j<n; j++) {
9                if(i>=j) {
10                    dp[i][j] = 0;
11                    continue;
12                }
13
14                if(s.charAt(i) == s.charAt(j)) {
15                    dp[i][j] = dp[i+1][j-1];
16                } else {
17                    dp[i][j] = 1 + Math.min(dp[i+1][j], dp[i][j-1]);
18                }
19
20            }
21        }
22
23        return dp[0][n-1];
24    }
25}