// Last updated: 7/8/2026, 9:22:57 AM
1class Solution {
2    public int numDistinct(String s, String t) {
3        
4        int m = s.length();
5        int n = t.length();
6
7        int[][] dp = new int[m+1][n+1];
8
9        for(int j=0; j<=n; j++) {
10            dp[m][j] = 0;
11        }
12
13        for(int i=0; i<=m; i++) {
14            dp[i][n] = 1;
15        }
16
17        for(int i=m-1; i>=0; i--) {
18            for(int j=n-1; j>=0; j--) {
19                if(s.charAt(i) == t.charAt(j)) dp[i][j] = dp[i+1][j] + dp[i+1][j+1];
20
21                else dp[i][j] = dp[i+1][j];
22            }
23        }
24
25        return dp[0][0];
26    }
27}