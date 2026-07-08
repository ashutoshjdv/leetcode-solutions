// Last updated: 7/8/2026, 8:25:53 AM
1class Solution {
2    public int minDistance(String word1, String word2) {
3        
4        int m = word1.length();
5        int n = word2.length();
6
7        int[][] dp = new int[m+1][n+1];
8
9        for(int j = 0; j<=n; j++) {
10            dp[m][j] = n - j;
11        }
12
13        for(int i = 0; i<=m; i++) {
14            dp[i][n] = m - i;
15        }
16
17        for(int i=m-1; i>=0; i--) {
18            for(int j=n-1; j >= 0; j--) {
19                if(word1.charAt(i) != word2.charAt(j)) {
20                    dp[i][j] = 1 + Math.min(dp[i+1][j], dp[i][j+1]);
21                } else {
22                    dp[i][j] = dp[i+1][j+1];
23                }
24            }
25        }
26
27        return dp[0][0];
28    } 
29}