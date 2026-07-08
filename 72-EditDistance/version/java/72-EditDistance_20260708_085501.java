// Last updated: 7/8/2026, 8:55:01 AM
1class Solution {
2    public int minDistance(String word1, String word2) {
3        int m = word1.length();
4        int n = word2.length();
5
6        int[][] dp = new int[m+1][n+1];
7
8        for(int i=0; i<=m; i++) {
9            dp[i][n] = m-i;
10        }
11
12        for(int j=0; j<=n; j++) {
13            dp[m][j] = n-j;
14        }
15
16        for(int i=m-1; i>=0 ; i--) {
17            for(int j=n-1; j>=0; j--) {
18
19                if(word1.charAt(i) == word2.charAt(j)) dp[i][j] = dp[i+1][j+1];
20
21                else dp[i][j] = 1 + Math.min(dp[i+1][j], Math.min(dp[i][j+1], dp[i+1][j+1]));
22            }
23        }
24
25        return dp[0][0];
26    }
27}